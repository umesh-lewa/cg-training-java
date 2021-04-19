package hellopack;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AddressMonitor implements SOAPHandler<SOAPMessageContext>{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		//called for both request and response....
		try {
			Boolean response=(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(response) {
				SOAPMessage soapMessage=context.getMessage();
				SOAPEnvelope soapEnvelope=soapMessage.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader=soapEnvelope.getHeader();
				if(soapHeader==null) {
					soapHeader=soapEnvelope.addHeader();
					System.out.println("no header present.......");
				}
				Iterator it=soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				if(it==null) {
					System.out.println("no actor element in soap header.....");
				}								
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("handle fault is called...");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("handler close is called...");
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		System.out.println("get headers called...");
		return null;
	}
	
}
