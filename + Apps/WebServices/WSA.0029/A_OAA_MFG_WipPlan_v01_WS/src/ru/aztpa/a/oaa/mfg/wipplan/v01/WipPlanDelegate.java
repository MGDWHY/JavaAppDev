package ru.aztpa.a.oaa.mfg.wipplan.v01;

import ru.aztpa.a.oaa.mfg.wipplan.v01.dbconn.DataBaseConnection;

import java.sql.SQLException;

class WipPlanDelegate
{
    ActionResult createWipPlan(Shop shop)
    {
        ActionResult actionResult = new ActionResult();
        if (shop == null)
        {
            actionResult.setMessage("There is no shop");
            actionResult.setReturnCode("-1");
            actionResult.setStatus("ERROR");
        }

        try
        {
            DataBaseConnection connection = null;
            try
            {
                connection = new DataBaseConnection();
                WipPlanQueryUnit queryExecutor = new WipPlanQueryUnit(connection.getDbConn());

                // ��� �����������. ��� ����� = 71
                String organizationCode = shop.getOrganizationCode();
                if (organizationCode == null || (organizationCode = organizationCode.trim()).isEmpty())
                    throw new RuntimeException("Organization code cannot be null or empty");

                // ����� ���� (��������, 0800)
                String shopCode = shop.getShopCode();
                if (shopCode == null || (shopCode = shopCode.trim()).isEmpty())
                    throw new RuntimeException("Shop code cannot be null or empty");

                // ������������ ���� (��������, ��� 0800 ��� "������������ ��� �8")
                String shopName = shop.getShopName();
                if (shopName == null || (shopName = shopName.trim()).isEmpty())
                    throw new RuntimeException("Shop name cannot be null or empty");

                queryExecutor.importPlanForDepartment(shopCode);

                actionResult.setMessage("Plan has been imported successfully for department " + shopCode);
                actionResult.setReturnCode("0");
                actionResult.setStatus("SUCCESS");
            }
            finally
            {
                if (connection != null)
                    connection.close();
            }
        }
        catch (SQLException sqlEx)
        {
            // throw new RuntimeException(sqlEx);
            actionResult.setMessage("SQL Error message: " + sqlEx.getMessage());
            actionResult.setReturnCode("SQL Error code: " + sqlEx.getErrorCode());
            actionResult.setStatus("ERROR");
        }

        return actionResult;
    }
}