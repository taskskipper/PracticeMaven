package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptWaiting {

 static WebDriver driver;
	
	public static void waitForJavascript(int maxWaitMillis, int pollDelimiter) throws InterruptedException {
	    double startTime = System.currentTimeMillis();
	    
	    while (System.currentTimeMillis() < startTime + maxWaitMillis) {
	        String prevState = driver.getPageSource();
	        Thread.sleep(pollDelimiter); // <-- would need to wrap in a try catch
	        if (prevState.equals(driver.getPageSource())) {
	            return;
	        }
	    }
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		
		waitForJavascript(50000, 500);
		// TODO Auto-generated method stub

		System.out.println(driver.getTitle());
		driver.quit();
		
	}

}
