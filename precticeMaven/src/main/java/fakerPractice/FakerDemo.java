package fakerPractice;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//	@Test
//	public void  demo() {

	Faker faker = new Faker();

	String name = faker.name().fullName(); // Miss Samanta Schmidt
	String firstName = faker.name().firstName(); // Emory
	String lastName = faker.name().lastName(); // Barton
	String streetAddress = faker.address().city();
//	String phn = faker.phoneNumber().cellPhone().replace(".", "").replace("-", "").replace(" ", "");
	String phnn = faker.phoneNumber().subscriberNumber(10);
	String fulladdress = faker.address().fullAddress();
	String city = faker.address().cityName();
	String countrycode = faker.address().zipCode();
	
//	faker.options();
//	faker.internet()	
//	faker.name().username();
	
	System.out.println(firstName +" " + lastName );
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(streetAddress);
	System.out.println("num " + phnn);
	System.out.println(fulladdress);
	System.out.println(countrycode);
	System.out.println(faker.expression("#{number.number_between '100000','99999'}"));
	System.out.println(faker.address().zipCodeByState(faker.address().stateAbbr()));
	
//	Per/son person = 
	
//			List<Person> people = RandomPerson.get().listOf(20);

	}
	

}
