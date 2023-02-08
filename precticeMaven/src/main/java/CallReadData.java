import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import fakerPractice.FakeData;

public class CallReadData {
	
	
	@Test
	public void strings() throws IOException, InvalidFormatException {
		
		DataStoringAndRetrive dr = new DataStoringAndRetrive();
		
		FakeData fake = new FakeData();
		List<String> strings = Arrays.asList(fake.FIRST_NAME, fake.LAST_NAME, fake.COMPANY);
//		List<String> strings = Arrays.asList(new FakeData().FIRST_NAME, new FakeData().LAST_NAME, new FakeData().COMPANY);

		
//		dr.addData(strings);
		
		List<String> data = dr.extractData();
		System.out.println(data);
		
		
	}

}
