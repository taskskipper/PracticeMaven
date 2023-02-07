package emailAutomate;

import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.*;

public class readmail {

	
	public static void main(String [] args) throws NamingException, MessagingException {
		
		InitialContext ic = new InitialContext();
		String snName = "java:comp/env/mail/MyMailSession";
		Session session = (javax.mail.Session)ic.lookup(snName);
		
		Properties props = session.getProperties();
		props.put("mail.from", "user2@mailserver.com");
		
		Store store = session.getStore();
		store.connect("premchand6479@gmail.com", "premchand6479@gmail.com", "ybxqyxdlplbvlcig");
		
		Folder folder = store.getFolder("INBOX");
		
		Message[] messages = folder.getMessages();
		
		
	}
	
	
	
	
	
	
}
