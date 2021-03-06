package ru.aztpa.a.vfp.mfg.masteroperations.v01;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 * This class was generated by the JAX-WS RI. Oracle JAX-WS 2.1.5 Generated source version: 2.1
 * <p/>
 */
@WebService(portName = "A_VFP_MFG_MasterOperations_v01SOAP",
            serviceName = "MasterOperations",
            targetNamespace = "http://www.aztpa.ru/a/vfp/mfg/MasterOperations/v01/",
            // wsdlLocation = "/wsdls/A_VFP_MFG_MasterOperations_v01.wsdl",
            endpointInterface = "ru.aztpa.a.vfp.mfg.masteroperations.v01.MasterOperationsPort")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class MasterOperations_A_VFP_MFG_MasterOperations_v01SOAPImpl
    implements MasterOperationsPort
{
    private WSMasterOperationWrapper callWrapper;

    public MasterOperations_A_VFP_MFG_MasterOperations_v01SOAPImpl()
    {
        callWrapper = new WSMasterOperationWrapper();
    }

    /**
     * Web-метод проверки операций справочника.
     * @param in < p/>
     * <p/>
     * @return returns ru.aztpa.a.vfp.mfg.masteroperations.v01.Result
     */
    public Result validateOperations(String in)
    {
        try
        {
            return callWrapper.doValidate(in);
        }
        catch (SQLException e)
        {
            Result theFailedResult = new Result();
            theFailedResult.setResultCode(-100);
            theFailedResult.setResultDescription("Internal error occured. See the log file");
            return theFailedResult;
        }
    }
}
