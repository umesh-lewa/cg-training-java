package codaws;

import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class MySOAPMonitor implements SOAPHandler<SOAPMessageContext>{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("handle message called.....");
		Boolean response =(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(response) {
			System.out.println("service is now responding....");
			System.out.println("Response Message....");
			SOAPMessage message=context.getMessage();
			try {
				message.writeTo(new PrintStream(System.out));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("request to service is happening......");
			System.out.println("Request Message....");
			SOAPMessage message=context.getMessage();
			try {
				message.writeTo(new PrintStream(System.out));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("handle fault called...");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("soap close method called...");
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		System.out.println("soap header method called....");
		return null;
	}

}
