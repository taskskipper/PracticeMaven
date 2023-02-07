package emailAutomate;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Store;

import com.testing.framework.EmailUtils;

public class EmailAutomation {

	public static void main(String [] args) throws Exception {
		
//		System.out.println("***************************");
		
		EmailUtils emailUtils = new EmailUtils();
		
		Properties prop = new Properties();
		
		prop.setProperty("to", "sillentkiller933@gmail.com");
		prop.setProperty("gmail_from", "premchand6479@gmail.com" );
		prop.setProperty("gmail_username", "premchand6479@gmail.com");
		prop.setProperty("gmail_password", "ybxqyxdlplbvlcig");
		prop.setProperty("gmail_port", "587");
		
		
		System.out.println(prop.get("gmail_username"));
		
		Store store = emailUtils.connectToGmail(prop);
		
		@SuppressWarnings("unchecked")
		List<String> emailText = emailUtils.getUnreadMessageByFromEmail(store, "Inbox", "hello@scaler.com", "Upcoming Masterclasses Schedule for you");
		
		Iterator<String> it = emailText.iterator();
		
		if(it.hasNext()) {
			
			String mailtxt = it.next();
			System.out.println(mailtxt);
		}
		
		
		System.out.println("****************end*******************");
	}
	
	
	
	
	
	
	
	
	
	
}
