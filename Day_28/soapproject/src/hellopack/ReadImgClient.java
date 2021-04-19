package hellopack;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ReadImgClient {
	
	public static void main(String[] args)throws Exception {
		
		QName serviceName=new QName("http://www.haaris.com","myservice");
		
		URL url=new URL("http://localhost/ws/helloService?wsdl");
		
		Service service=Service.create(url, serviceName);
		
		HelloService myservice=service.getPort(HelloService.class);
		
		Image img=myservice.getImage("copyflo.jpg");
		
		JFrame jf=new JFrame();
		jf.setSize(300,300);
		
		JLabel jl=new JLabel(new ImageIcon(img));
		
		jf.add(jl);
		jf.setVisible(true);
	}
	
}
