package ru.aztpa.a.oaa.mfg.shop.v01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ShopQueryExecutor
{
    private final ShopProfile shopProfile;
    private final Connection dbConn;

    public ShopQueryExecutor(ShopProfile profile, Connection connection)
    {
        assert profile != null;
        assert connection != null;
        shopProfile = profile;
        dbConn = connection;
    }

    public List<? extends Shop> retrieveShopListByProfile()
       throws SQLException
    {
        ShopQueryBuilder queryBuilder = new ShopQueryBuilder();
        PreparedStatement pStat = null;
        ResultSet resultSet = null;
        try
        {
            pStat = dbConn.prepareStatement(queryBuilder.buildShopListQuery());
            resultSet = pStat.executeQuery();
            List<Shop> shops = new ArrayList<Shop>();
            while (resultSet.next())
            {
                String departmentCode = resultSet.getString("shop_code");
                String description = resultSet.getString("shop_name");
                String organizationName = resultSet.getString("organization_name");
                String organizationCode = resultSet.getString("organization_code");
                Integer organizationId = resultSet.getInt("organization_id");

                Shop shop = new Shop();
                shop.setShopCode(departmentCode);
                shop.setShopName(description);
                Plant plant = new Plant();
                plant.setOrganizationName(organizationName);
                plant.setOrganizationCode(organizationCode);
                plant.setOrganizationId(organizationId);
                shop.setPlant(plant);
                shops.add(shop);
            }

            return shops;
        }
        finally
        {
            if (pStat != null && !pStat.isClosed())
                pStat.close();
            if (resultSet != null && !resultSet.isClosed())
                resultSet.close();
        }
    }

    private class ShopQueryBuilder
    {
        private final String qShopListByProfileBase =
           new StringBuilder().append("SELECT ").append("   department_code AS shop_code, ").append(
              "   description AS shop_name, ").append("   organization_name, ").append("   organization_code, ").append(
              "   o.organization_id ").append("FROM ").append("   bom_departments d, ").append(
              "   org_organization_definitions o ").append("WHERE ").append(
              " d.organization_id = o.organization_id ").toString();

        ShopQueryBuilder() {}

        private String buildShopListQuery()
           throws SQLException
        {
            StringBuilder qShopListByProfile = new StringBuilder(qShopListByProfileBase);

            String orgCode = shopProfile.getOrganizationCode();
            if (orgCode != null && !orgCode.trim().isEmpty())
            {
                orgCode = orgCode.trim();
                qShopListByProfile.append(String.format(" AND organization_code LIKE '%s' ", orgCode));
            }

            String orgName = shopProfile.getOrganizationName();
            if (orgName != null && !orgName.trim().isEmpty())
            {
                orgName = orgName.trim();
                qShopListByProfile.append(String.format(" AND organization_name LIKE '%s' ", orgName));
            }

            String depCode = shopProfile.getShopCode();
            if (depCode != null && !depCode.trim().isEmpty())
            {
                depCode = depCode.trim();
                qShopListByProfile.append(String.format(" AND department_code LIKE '%s' ", depCode));
            }

            String depDesc = shopProfile.getShopName();
            if (depDesc != null && !depDesc.trim().isEmpty())
            {
                depDesc = depDesc.trim();
                qShopListByProfile.append(String.format(" AND description LIKE '%s' ", depDesc));
            }

            return qShopListByProfile.toString();
        }
    }
}
