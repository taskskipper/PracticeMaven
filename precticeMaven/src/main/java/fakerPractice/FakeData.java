package fakerPractice;

import java.util.Arrays;
import com.github.javafaker.Faker;

public class FakeData {

	public String FIRST_NAME;
	public String LAST_NAME;
	public String PHONE_NUMBER;
	public String COMPANY;
	public String LEAD_SOURCE;
	public String LEAD_STATUS;
	public String RATING;
	public String STREET;
	public String CITY;
	public String STATE;
	public String ZIP;
	public String COUNTRY;
	public String DESCRIPTION;

	Faker faker = new Faker();

	public FakeData() {

		FIRST_NAME = faker.name().firstName();
		LAST_NAME = faker.name().lastName();
		PHONE_NUMBER = faker.phoneNumber().subscriberNumber(10);
		COMPANY = faker.company().name();
		STREET = faker.address().streetName();
		CITY = faker.address().cityName();
		STATE = faker.address().state();
		ZIP = faker.address().zipCode();
		COUNTRY = faker.address().country();
		DESCRIPTION = faker.company().industry();
		RATING = Rating();
		LEAD_SOURCE = LeadSource();
		LEAD_STATUS = LeadStatus();
	}

	private String Rating() {

		return faker.options().nextElement(Arrays.asList("Hot", "Warm", "Cold"));

	}

	private String LeadSource() {

		/*
		 * "Existing Customer", "New Contact", "Email", "WebSite", "Event", "Webinar", "Social Media"
		 */
		
		
		return faker.options()
				.nextElement(Arrays.asList("Existing Customer", "New Contact", "Email", "WebSite", "Event", "Webinar",
						"Social Media", "Professional Services Referral", "Curriculum Specialist Referral"));

	}

	private String LeadStatus() {

		/*
		 * "Unqualified", "Qualified", "Disqualified", "Unreachable"
		 */
		return faker.options()
				.nextElement(Arrays.asList("Unqualified", "Qualified", "Disqualified", "Unreachable", "Archived"));

	}

}
