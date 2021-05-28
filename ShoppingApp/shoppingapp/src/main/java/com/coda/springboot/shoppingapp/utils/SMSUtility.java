package com.coda.springboot.shoppingapp.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSUtility {
	
	private static String ACCOUNT_SID,AUTH_TOKEN;
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("application");

	private static void getProps() {
		
		try {
			ACCOUNT_SID=bundle.getString("sms.ACCOUNT_SID");
			AUTH_TOKEN=bundle.getString("sms.AUTH_TOKEN");
			System.out.println("sms.ACCOUNT_SID : "+ACCOUNT_SID);
			System.out.println("sms.AUTH_TOKEN : "+AUTH_TOKEN);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// Find your Account Sid and Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    //public static final String ACCOUNT_SID = "";
    //public static final String AUTH_TOKEN = "";
    
    public String sendSMS(String to,String msg) {
    	
    	getProps();
    	
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(to),
                new com.twilio.type.PhoneNumber("+16788315071"),msg)
            .create();

        System.out.println("message.getSid() : "+message.getSid());
        
        return message.getSid();       
    }
    
    // Driver Code
    public static void main(String[] args) {
    	/*
    	SMSUtility sms = new SMSUtility();
    	String sid = sms.sendSMS("+919500130553", "Hi froom Rmi Service");
    	
    	System.out.println("sid : "+sid);
    	*/
    }

}
