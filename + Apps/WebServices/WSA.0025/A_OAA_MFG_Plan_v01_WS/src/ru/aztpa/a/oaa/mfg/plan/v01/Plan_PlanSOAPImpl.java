package ru.aztpa.a.oaa.mfg.plan.v01;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 * This class was generated by the JAX-WS RI. Oracle JAX-WS 2.1.5 Generated
 * source version: 2.1
 * 
 */
@WebService(portName = "PlanSOAP", serviceName = "Plan",
		targetNamespace = "http://www.aztpa.ru/a/oaa/mfg/plan/v01/",
		// wsdlLocation = "/wsdls/A_OAA_MFG_Plan_v01.wsdl",
		endpointInterface = "ru.aztpa.a.oaa.mfg.plan.v01.PlanPortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class Plan_PlanSOAPImpl implements PlanPortType
{
	private PlanHelper piHelper;
	
	public Plan_PlanSOAPImpl()
	{
		piHelper = new PlanHelper();
	}

	/**
     * �������� Web-������� ��� ������� ������ � ������� XXODI.XXBI_PLANS, XXODI.XXBI_PLANPOSITIONS ���� Oracle
     * @param plan ������ ���� ��� ������������ "�����������" � SOAP-request
     * @return returns ru.aztpa.a.oaa.mfg.plan.v01.ActionResult
     */
    @Override
	public ActionResult createPlan(Plan plan)
	{
		return piHelper.doCreatePlan(plan);
	}

	/**
	 * @param profile
	 * @return returns ru.aztpa.a.oaa.mfg.plan.v01.PlannedFgList
	 */
    @Override
	public PlannedFgList findPlannedFgListByProfile(PlannedFgProfile profile)
	{
		return piHelper.doFindPlannedFgListByProfile(profile);
	}
}