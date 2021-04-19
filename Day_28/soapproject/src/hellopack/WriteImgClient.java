package hellopack;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class WriteImgClient {
	
	public static void main(String[] args)throws Exception {
		
		QName serviceName=new QName("http://www.haaris.com","myservice");
		
		URL url=new URL("http://localhost/ws/helloService?wsdl");
		
		Service service=Service.create(url, serviceName);
		
		HelloService myservice=service.getPort(HelloService.class);
		
		BindingProvider binding=(BindingProvider)myservice;
		SOAPBinding soapBinding=(SOAPBinding)binding.getBinding();
		soapBinding.setMTOMEnabled(true);
		
		Image img=ImageIO.read(new File("flower.jpg"));
		myservice.setImage(img, "copyflo.jpg");
					
	}
		
}
