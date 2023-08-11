package dataStore;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.javafaker.Faker;

import fakerPractice.FakeData;

public class readexcel {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		
		RetriveAndStoreData rd = new RetriveAndStoreData();
		
//		rd.addData(Arrays.asList("thermodynamin"));
		
//		rd.addData(Arrays.asList(new FakeData().FIRST_NAME,new FakeData().LAST_NAME, new FakeData().COMPANY ));
		List<String> d = rd.data;
//		System.out.println(rd.getAccName());
//		System.out.println(rd.getConName());
//		System.out.println(rd.getOppName());
		System.out.println(d);
//	
//
		Faker faker = new Faker();
//		
//		System.out.println(rd.data );
//		System.out.println(rd.data.size());
	
//		System.out.println("Auto Added - " + faker.app().name());
//

//		rd.addCourse("Auto Added - " + faker.app().name());
		
//		System.out.println(rd.getCourseName());
//		rd.addModule("viscosity");
//		System.out.println(rd.getModule());
		
//		System.out.println(rd.getCourseWithModules());
//		System.out.println(rd.getCourseName());
//		System.out.println(rd.getCourseNameToBeDeleted());

//		System.out.println(rd.getModuleNameToBeDeleted());
//		rd.addCourse(faker.name().firstName());
//		rd.addModule(faker.name().lastName());
//		rd.addModule(faker.name().lastName());
//		
//		System.out.println(rd.getCourseName());
//		System.out.println(rd.getModule());
		
		System.out.println(rd.getCourseNameToBeDeleted());
		
		
		

	}

}
