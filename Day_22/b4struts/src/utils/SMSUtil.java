package utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSUtil {

	private static String ACCOUNT_SID,AUTH_TOKEN;
	
	private static void getProps(ServletContext context) {
		
		try {
			Properties prop=new Properties();
			//Properties prop= (Properties)context.getAttribute("dbconfigpath");
			//prop.load(new FileInputStream(context.getAttribute("dbconfigpath").toString()));
			prop.load(new FileInputStream(context.getAttribute("dbconfigpath").toString()));
			ACCOUNT_SID=prop.getProperty("ACCOUNT_SID");
			AUTH_TOKEN=prop.getProperty("AUTH_TOKEN");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// Find your Account Sid and Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    //public static final String ACCOUNT_SID = "";
    //public static final String AUTH_TOKEN = "";

    
    public String sendSMS(String to,String msg, ServletContext ctx) {
    	
    	getProps(ctx);
    	
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(to),
                new com.twilio.type.PhoneNumber("+16788315071"),msg)
            .create();

        System.out.println(message.getSid());
        
        return message.getSid();
        
    }
    
    public static void main(String[] args) {
    	/*
    	OnlineSMSRmiService sms = new OnlineSMSRmiService();
    	String sid = sms.sendSMS("+919500130553", "Hi froom Rmi Service");
    	
    	System.out.println("sid : "+sid);
    	*/
        
    }
    
}
