package macheaderpack;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@HandlerChain(file="handler-chain.xml")
@WebService(endpointInterface = "macheaderpack.AddressService")
public class AddressServiceImpl implements AddressService{
	
	@Resource
	WebServiceContext ctx;
	
	@WebMethod
	@Override
	public String sayHello(String name) {
		return "welcome to webservices...:"+name;
	}
	
}
