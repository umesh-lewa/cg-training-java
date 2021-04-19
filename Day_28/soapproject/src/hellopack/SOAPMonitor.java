package hellopack;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPMonitor implements SOAPHandler<SOAPMessageContext>{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		//called for both request and response....
		try {
			Boolean response=(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(response) {
				SOAPMessage soapMessage=context.getMessage();
				System.out.println("\nReponse....");
				FileOutputStream fos=new FileOutputStream("response.xml");
				soapMessage.writeTo(new PrintStream(System.out));
				soapMessage.writeTo(fos);
			}
			else {
				SOAPMessage soapMessage=context.getMessage();
				System.out.println("\nRequest..........");
				FileOutputStream fos=new FileOutputStream("request.xml");
				soapMessage.writeTo(new PrintStream(System.out));
				soapMessage.writeTo(fos);
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
