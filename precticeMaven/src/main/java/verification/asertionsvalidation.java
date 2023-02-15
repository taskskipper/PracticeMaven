package verification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class asertionsvalidation {

	static WebDriver driver;

	public static void main(String[] args) {
		Map<String, String> hash = new HashMap<String, String>();
		Map<String, String> hash1 = new HashMap<String, String>();
		hash1.put("p", "10");
		hash.put("prop", "5%");
		hash1.put("prop", "5%");
		hash.put("p", "10");
		
		String[] exp = {"--Title--","Mr","Mrs","Miss","Ms","Dr","Prof"};
		WebElement dropdown = driver.findElement(By.id("ddlNights"));
		Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();
	
		
		
		for(WebElement we:options){
			boolean match = false;
			for (int i=0; i<exp.length; i++){
				if (we.getText().equals(exp[i])){
					match = true;}}
			Assert.assertTrue(match);
					}
		
		
		
		System.out.println(hash);
		System.out.println(hash1);
		
		Assert.assertEquals(hash, hash1);
		System.out.println("pass");
		
	}

}
