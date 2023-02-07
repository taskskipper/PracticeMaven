package fakerPractice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class callfaker {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		WebDriver driver = new ChromeDriver();
		FakeData fakeData = new FakeData();
		String fn = fakeData.FIRST_NAME;
		System.out.println(fakeData.RATING);
		String ls = fakeData.LEAD_SOURCE;
//		System.out.println(fakeData.faker.bothify("?????####?", true));
		System.out.println(fakeData.LEAD_SOURCE + " "+ fakeData.LEAD_STATUS);
		
		Date day = fakeData.faker.date().future(180, TimeUnit.DAYS);
		SimpleDateFormat df = new SimpleDateFormat("d/MM/YYYY");
		
		System.out.println(df.format(day));
		
	
		
	}
	

}
