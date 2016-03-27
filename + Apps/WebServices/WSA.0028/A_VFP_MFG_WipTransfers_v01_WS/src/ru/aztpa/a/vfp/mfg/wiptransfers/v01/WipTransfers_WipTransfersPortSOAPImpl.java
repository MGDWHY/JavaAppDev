package ru.aztpa.a.vfp.mfg.wiptransfers.v01;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingType;

/**
 * This class was generated by the JAX-WS RI. Oracle JAX-WS 2.1.5 Generated source version: 2.1
 *
 */
@WebService(portName = "WipTransfersPortSOAP",
            serviceName = "WipTransfers",
            targetNamespace = "http://www.aztpa.ru/a/vfp/mfg/wiptransfers/v01/",
            // wsdlLocation = "/wsdls/A_VFP_MFG_WipTransfers_v01.wsdl",
            endpointInterface = "ru.aztpa.a.vfp.mfg.wiptransfers.v01.WipTransfersPortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class WipTransfers_WipTransfersPortSOAPImpl implements WipTransfersPortType
{
   public WipTransfers_WipTransfersPortSOAPImpl()
   {
   }

   /**
    *
    * @param sourceDepartment
    * @param transferDocs
    * @return returns ru.aztpa.a.vfp.mfg.wiptransfers.v01.ActionResult
    */
   @Override
   public ActionResult synchronizeTransferDocs(Department sourceDepartment, TransferDocs transferDocs)
   {
      WipTransfersHelper helper = WipTransfersHelper.createWipTransferHelper(sourceDepartment);
      ActionResult result = helper.synchronizeTransferDocs(transferDocs);
      helper.closeConnection();
      return result;
   }

   /**
    *
    * @param sourceDepartmentCode
    * @return returns javax.xml.datatype.XMLGregorianCalendar
    */
   @Override
   public XMLGregorianCalendar getLastSyncDateForShop(String sourceDepartmentCode)
   {
      WipTransfersHelper helper = WipTransfersHelper.createWipTransferHelper(sourceDepartmentCode);
      XMLGregorianCalendar lastUpdateDate = helper.getLastSyncDateForShop();
      helper.closeConnection();
      return lastUpdateDate;
   }
}