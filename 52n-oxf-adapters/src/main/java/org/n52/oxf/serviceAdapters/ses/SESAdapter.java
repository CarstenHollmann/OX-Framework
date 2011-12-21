/**********************************************************************************
 Copyright (C) 2009
 by 52 North Initiative for Geospatial Open Source Software GmbH

 Contact: Andreas Wytzisk 
 52 North Initiative for Geospatial Open Source Software GmbH
 Martin-Luther-King-Weg 24
 48155 Muenster, Germany
 info@52north.org

 This program is free software; you can redistribute and/or modify it under the
 terms of the GNU General Public License version 2 as published by the Free
 Software Foundation.

 This program is distributed WITHOUT ANY WARRANTY; even without the implied
 WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 General Public License for more details.

 You should have received a copy of the GNU General Public License along with this 
 program (see gnu-gplv2.txt). If not, write to the Free Software Foundation, Inc., 
 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or visit the Free Software
 Foundation web page, http://www.fsf.org.

 Created on: 06.01.2006
 *********************************************************************************/
package org.n52.oxf.serviceAdapters.ses;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.opengis.ows.x11.ExceptionReportDocument;
import net.opengis.ows.x11.ExceptionType;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.n52.oxf.OXFException;
import org.n52.oxf.owsCommon.ExceptionReport;
import org.n52.oxf.owsCommon.OWSException;
import org.n52.oxf.owsCommon.OwsExceptionReport.ExceptionCode;
import org.n52.oxf.owsCommon.ServiceDescriptor;
import org.n52.oxf.owsCommon.capabilities.Operation;
import org.n52.oxf.serviceAdapters.IServiceAdapter;
import org.n52.oxf.serviceAdapters.OperationResult;
import org.n52.oxf.serviceAdapters.ParameterContainer;
import org.n52.oxf.util.IOHelper;
import org.w3.x2003.x05.soapEnvelope.Body;
import org.w3.x2003.x05.soapEnvelope.Envelope;
import org.w3.x2003.x05.soapEnvelope.EnvelopeDocument;
import org.w3.x2003.x05.soapEnvelope.Header;

/**
 * SES-Adapter for the OX-Framework<br>
 * 
 * TODO implement missing operations<br>
 * 
 * Current state (could not be tested because of missing dp compliant instance):
 * <ul>
 *      <li>GetCapabilities implemented</li>
 *      <li>Subscribe</li>
 *      <li>Notify</li>
 *      <li>RegisterPublisher</li>
 * </ul>
 * 
 * @author <a href="mailto:artur.osmanov@uni-muenster.de">Artur Osmanov</a>
 * @author <a href="mailto:ehjuerrens@uni-muenster.de">Eike Hinderk J&uuml;rrens</a>
 */
public class SESAdapter implements IServiceAdapter {

    private static final Logger LOGGER = Logger.getLogger(SESAdapter.class);

    public static final String SUBSCRIBE = "Subscribe";
    public static final String UNSUBSCRIBE = "UnSubscribe";
    public static final String GET_CAPABILITIES = "GetCapabilities";
    public static final String REGISTER_PUBLISHER = "Register";
    public static final String NOTIFY = "Notify";
    public static final String DESCRIBE_SENSOR = "DescribeSensor";
    public static final String NOTIFY_RESPONSE = "NotifyResponse";

    /**
     * Description of the SESAdapter
     */
    public static final String DESCRIPTION = "This Class implements the Service Adapter Interface and is"
        + "an SES Adapter for the OXF Framework";

    /**
     * The name of the service operation which returns the data to be added to a map view as a layer.
     */
    public static final String RESOURCE_OPERATION = null;

    /**
     * The Type of the service which is connectable by this ServiceAdapter
     */
    public static final String SERVICE_TYPE = "SES";

    /**
     * the Versions of the services which are connectable by this ServiceAdapter. Should look like e.g.
     * {"1.1.0","1.2.0"}.
     */
    public static final String[] SUPPORTED_VERSIONS = {"0.0.0"};

    private ParameterContainer paramCont = null;

    private String serviceVersion = this.SUPPORTED_VERSIONS[0];

    /**
     * constructor which instantiates
     */
    public SESAdapter() {
        this(SUPPORTED_VERSIONS[0]);
    }

    /**
     * 
     * @param serviceVersion
     *        the schema version for which this adapter instance shall be initialized.
     */
    public SESAdapter(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public SESAdapter(ParameterContainer paramCont) {
        this.paramCont = paramCont;
    }

    /* 
     * what needs to be done to init the SESAdapter => GetCapabilities?
     */
    public ServiceDescriptor initService(String serviceURL) throws ExceptionReport, OXFException {


        ParameterContainer parameters = new ParameterContainer();
        parameters.addParameterShell(ISESRequestBuilder.GET_CAPABILITIES_SES_URL, serviceURL);

        OperationResult opResult = doOperation(new Operation(SESAdapter.GET_CAPABILITIES, 
                serviceURL, serviceURL), parameters);
        
        try {
            // free OWS Response from SOAP-Envelope

            EnvelopeDocument envDoc = EnvelopeDocument.Factory.parse(opResult.getIncomingResultAsStream());

            String owsResponse = envDoc.getEnvelope().getBody().xmlText();

            net.opengis.ses.x00.CapabilitiesDocument capsDoc = net.opengis.ses.x00.CapabilitiesDocument.Factory.parse(owsResponse);

           return handleCapabilities(capsDoc);

        } catch (XmlException e) {
            throw new OXFException(e);
        }
        catch (IOException e) {
            throw new OXFException(e);
        }



    }

    private ServiceDescriptor handleCapabilities(net.opengis.ses.x00.CapabilitiesDocument capsDoc) throws OXFException {
        SESCapabilitiesMapper_00 mapper = new SESCapabilitiesMapper_00();

        ServiceDescriptor result = mapper.mapCapabilities(capsDoc);

        return result;
    }

    public OperationResult doOperation(Operation operation,
            ParameterContainer parameterContainer) throws ExceptionReport,
            OXFException {

        String request = null;
        ISESRequestBuilder requestBuilder = SESRequestBuilderFactory.generateRequestBuilder(this.serviceVersion);
        OperationResult result = null;

        if(operation!=null){
        	
        // SUBSCRIBE
        if (operation.getName().equals(SESAdapter.SUBSCRIBE)) {
            request = requestBuilder.buildSubscribeRequest(parameterContainer);
            
            // UNSUBSCRIBE
        } else if(operation.getName().equals(SESAdapter.UNSUBSCRIBE)){
            request = requestBuilder.buildUnsubscribeRequest(parameterContainer);

            // GET_CAPABILITIES
        } else if(operation.getName().equals(SESAdapter.GET_CAPABILITIES)){
            request = requestBuilder.buildGetCapabilitiesRequest(parameterContainer);

            // NOTIFY
        } else if(operation.getName().equals(SESAdapter.NOTIFY)){
            request = requestBuilder.buildNotifyRequest(parameterContainer);

            // REIGSER_PUBLISHER
        } else if(operation.getName().equals(SESAdapter.REGISTER_PUBLISHER)){
            request = requestBuilder.buildRegisterPublisherRequest(parameterContainer);

            // DESCRIBE_SENSOR
        } else if(operation.getName().equals(SESAdapter.DESCRIBE_SENSOR)){
            request = requestBuilder.buildDescribeSensorRequest(parameterContainer);

            // NOTIFY_RESPONSE
        } else if(operation.getName().equals(SESAdapter.NOTIFY_RESPONSE)){
            request = SESResponseBuilderFactory.generateResponseBuilder(this.serviceVersion).buildNotifyResponseRequest(parameterContainer);

            // Operation not supported
        } else {
            throw new OXFException("The operation '" + operation.getName()
                    + "' is not supported.");
        }
        try {
            InputStream is = IOHelper.sendPostMessage(operation.getDcps()[0]
                                                                          .getHTTPPostRequestMethods().get(0).getOnlineResource()
                                                                          .getHref(), request);

            /*
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			String line;
	        System.out.println("Request vom SES: ");
	        while ((line = rd.readLine()) != null) {
	        	System.out.println(line);
	        }
             */
            result = new OperationResult(is, parameterContainer, request);

            try {
                ExceptionReport execRep = parseExceptionReport_000(result);

                throw execRep;
            }
            catch (XmlException e) {
                // parseError --> no ExceptionReport was returned.
                LOGGER.info("Service reported no 0.0.0 exceptions.");
            }

            try {
                ExceptionReport execRep = parseExceptionReport_100(result);

                throw execRep;
            }
            catch (XmlException e) {
                // parseError --> no ExceptionReport was returned.
                LOGGER.info("Service reported no 1.0.0 exceptions.");
            }

        } catch (IOException e) {
            throw new OXFException(e);
        }
        }

        return result;
    }

    public XmlObject handle(String operationName, ByteArrayInputStream input) throws OXFException{
        XmlObject result = null;
        Envelope env;
        Header header;
        Body body;

        if(operationName != null && input != null){
            try{
                if(operationName.equals(SESAdapter.REGISTER_PUBLISHER)){
                    env = EnvelopeDocument.Factory.parse(input).getEnvelope();
                    header = env.getHeader();
                    body = env.getBody();

                    // check for right action
                    // http://docs.oasis-open.org/wsn/brw-2/RegisterPublisher/RegisterPublisherResponse
                    XmlObject[] actions = header.selectPath("declare namespace s='http://www.w3.org/2005/08/addressing' .//s:Action");
                    String action = null;

                    // is this the right request? If NOT throw Exception
                    if(actions != null && actions.length == 1){
                        action = actions[0].getDomNode().getFirstChild().getNodeValue();
                        if(!action.equals("http://docs.oasis-open.org/wsn/brw-2/RegisterPublisher/RegisterPublisherResponse")){
                            throw new OXFException(ExceptionCode.OperationNotSupported + ": Not the right response: \"" + action + " \" <-> Expected is: \"http://docs.oasis-open.org/wsn/brw-2/RegisterPublisher/RegisterPublisherResponse\"!");
                        }
                    }

                    // TODO Problem with Namespace and XMLBeans: The document is not a RegisterPublisherResponse@http://docs.oasis-open.org/wsn/br-2: document element namespace mismatch expected "http://docs.oasis-open.org/wsn/br-2" got "http://docs.oasis-open.org/wsn/brw-2"
                    result = XmlObject.Factory.parse(body.toString());
                    if(result instanceof org.oasisOpen.docs.wsn.br2.impl.RegisterPublisherResponseDocumentImpl){
                        // soap envelope => body => registerpublisher
                        result = ((org.oasisOpen.docs.wsn.br2.impl.RegisterPublisherResponseDocumentImpl)result).getRegisterPublisherResponse();
                    }
                }
            } catch (IOException e){
                throw new OXFException(e);
            } catch (XmlException e) {
                // TODO what about SOAP-Exceptions?
                throw new OXFException("RegisterPublisherResponse not wellformed XML",e);
            }
        }
        return result;
    }

    public String getDescription() {
        return SESAdapter.DESCRIPTION;
    }

    public String getResourceOperationName() {
        return RESOURCE_OPERATION;
    }

    public String getServiceType() {
        return SESAdapter.SERVICE_TYPE;
    }

    public String[] getSupportedVersions() {
        return SESAdapter.SUPPORTED_VERSIONS;
    }

    /**
     * checks whether the response of the doOperation is an ExceptionReport. If it is, the report with the
     * contained OWSExceptions are parsed and a new ExceptionReport is created and will be returned.
     * 
     * @throws ExceptionReport
     *         the exception report containing the service exceptions
     * @throws OXFException
     *         if an parsing error occurs
     * @throws XmlException
     */
    // TODO could be externalized because the same methods are use in the SOSAdapter => identify common ServiceAdapterTasks
    private ExceptionReport parseExceptionReport_000(OperationResult result) throws XmlException {

        String requestResult = new String(result.getIncomingResult());

        ExceptionReportDocument xb_execRepDoc = ExceptionReportDocument.Factory.parse(requestResult);
        ExceptionType[] xb_exceptions = xb_execRepDoc.getExceptionReport().getExceptionArray();

        String language = xb_execRepDoc.getExceptionReport().getLang();
        String version = xb_execRepDoc.getExceptionReport().getVersion();

        ExceptionReport oxf_execReport = new ExceptionReport(version, language);
        for (ExceptionType xb_exec : xb_exceptions) {
            String execCode = xb_exec.getExceptionCode();
            String[] execMsgs = xb_exec.getExceptionTextArray();
            String locator = xb_exec.getLocator();

            OWSException owsExec = new OWSException(execMsgs, execCode, result.getSendedRequest(), locator);

            oxf_execReport.addException(owsExec);
        }

        return oxf_execReport;
    }

    private ExceptionReport parseExceptionReport_100(OperationResult result) throws XmlException {

        String requestResult = new String(result.getIncomingResult());

        net.opengis.ows.x11.ExceptionReportDocument xb_execRepDoc = net.opengis.ows.x11.ExceptionReportDocument.Factory.parse(requestResult);
        net.opengis.ows.x11.ExceptionType[] xb_exceptions = xb_execRepDoc.getExceptionReport().getExceptionArray();

        String language = xb_execRepDoc.getExceptionReport().getLang();
        String version = xb_execRepDoc.getExceptionReport().getVersion();

        ExceptionReport oxf_execReport = new ExceptionReport(version, language);
        for (net.opengis.ows.x11.ExceptionType xb_exec : xb_exceptions) {
            String execCode = xb_exec.getExceptionCode();
            String[] execMsgs = xb_exec.getExceptionTextArray();
            String locator = xb_exec.getLocator();

            OWSException owsExec = new OWSException(execMsgs, execCode, result.getSendedRequest(), locator);

            oxf_execReport.addException(owsExec);
        }

        return oxf_execReport;

    }

}
