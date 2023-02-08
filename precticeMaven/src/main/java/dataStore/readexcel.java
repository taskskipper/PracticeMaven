package dataStore;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import fakerPractice.FakeData;

public class readexcel {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		
		RetriveAndStoreData rd = new RetriveAndStoreData();
		
//		rd.addData(Arrays.asList(new FakeData().FIRST_NAME,new FakeData().COMPANY ));
		List<String> d = rd.extractData();
		System.out.println(d);
		

	}

}
