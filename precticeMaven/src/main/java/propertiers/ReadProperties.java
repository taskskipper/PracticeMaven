package propertiers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream s = new FileInputStream("C:\\Users\\acer\\git\\PracticeMaven\\precticeMaven\\src\\main\\java\\propertiers\\prem.properties");
		prop.load(s);
		prop.setProperty("browser", "chrome");
		System.out.println(prop.size());
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("browser"));

	}
	
}

