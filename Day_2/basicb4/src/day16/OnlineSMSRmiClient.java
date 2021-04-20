package day16;

import java.io.File;
import java.rmi.Naming;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OnlineSMSRmiClient {
	
	public static void main(String args[]) throws Exception {
		
		
		SMS sms=(SMS)Naming.lookup("rmi://localhost:1099/rmiservice/SMSService");
		String sid = sms.sendSMS("+919500130553", "Hi SMS from Client Rmi");
		
		System.out.println("sid : "+sid);
		
		
		//From XML
		/*
		try {
		
	         File inputFile = new File("OnlineSMSRmiClient.xml");
	         
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         
	         //NodeList nList = doc.getElementsByTagName("student");
	         NodeList nList = doc.getChildNodes();
	         System.out.println("----------------------------");
	         
	         String to = "";
	         String msg = "";
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	
	               Element eElement = (Element) nNode;
	               System.out.println("eElement : "+eElement);
	              
	               to = eElement.getElementsByTagName("to").item(0).getTextContent();
	               msg = eElement.getElementsByTagName("msg").item(0).getTextContent();
	               
	               System.out.println("to : "  + eElement.getElementsByTagName("to").item(0).getTextContent());
	               System.out.println("msg : "   + eElement.getElementsByTagName("msg").item(0).getTextContent());
	               
	            }
	         }
	         
	        SMS sms=(SMS)Naming.lookup("rmi://localhost:1099/rmiservice/SMSService");
	 		String sid = sms.sendSMS(to, msg);
	 		
	 		System.out.println("sid : "+sid);
	 		
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      */
	}

}
