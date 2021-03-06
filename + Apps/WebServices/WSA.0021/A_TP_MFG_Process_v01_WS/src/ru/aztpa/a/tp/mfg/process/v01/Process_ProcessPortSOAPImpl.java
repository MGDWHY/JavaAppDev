package ru.aztpa.a.tp.mfg.process.v01;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.sql.SQLException;
import java.util.List;

/**
 * This class was generated by the JAX-WS RI. Oracle JAX-WS 2.1.5 Generated source version: 2.1
 */
@WebService(portName = "ProcessPortSOAP",
            serviceName = "Process",
            targetNamespace = "http://www.aztpa.ru/a/tp/mfg/process/v01/",
            // wsdlLocation = "/wsdls/A_TP_MFG_Process_v01.wsdl",
            endpointInterface = "ru.aztpa.a.tp.mfg.process.v01.ProcessPortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class Process_ProcessPortSOAPImpl implements ProcessPortType
{
    private CalledWrapper calledWrapper;

    public Process_ProcessPortSOAPImpl()
    {
        calledWrapper = new CalledWrapper();
    }

    /**
     * @param profile
     * @return returns java.util.List<ru.aztpa.a.tp.mfg.process.v01.Process>
     */
    @Override
    public List<Process> findProcessListByProfile(Profile profile)
    {
        try
        {
            return calledWrapper.doFindProcessListByProfile(profile);
        }
        catch (SQLException sqlEx)
        {
            throw new RuntimeException(sqlEx);
        }
    }

    /**
     * @param id
     * @return returns ru.aztpa.a.tp.mfg.process.v01.ProcessDetail
     */
    @Override
    public ProcessDetail getProcessDetailById(long id)
    {
        try
        {
            return calledWrapper.doGetProcessDetailById(id);
        }
        catch (SQLException sqlEx)
        {
            throw new RuntimeException(sqlEx);
        }
    }
}
