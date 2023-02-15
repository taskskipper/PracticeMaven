package fakerPractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDate {

	public static Calendar cal = Calendar.getInstance();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ParseException {
		
//		javaDate d = new JavaDate()
		
		
//		System.out.println(getFirstDateOfFinancialYear());
		System.out.println(new JavaDate().getLastDateOfFinancialYear());
		
		
	}
	
	 public static String getFirstDateOfFinancialYear() {
         
         Calendar cal = Calendar.getInstance();
         Calendar currentDate = Calendar.getInstance();
         currentDate.add(Calendar.MONDAY, 3);
         
         
         Date currentDay = currentDate.getTime();
         System.out.println(currentDay);
         
         DateFormat df = new SimpleDateFormat("d/M/YYYY");
		 int year = cal.get(Calendar.YEAR);
		 
		 cal.set(year, 2, 31); // 31 March of Year
//         cal.set(year, 2, 1); // 1 of march
         Date firstMarchOfYear = cal.getTime();
 
         
         if (currentDay.after(firstMarchOfYear)) {
             return df.format(firstMarchOfYear);
         } else {
             cal.set(year - 1, 2, 1);
             return df.format(cal.getTime());
         }
     }
	
	 public String getLastDateOfFinancialYear() {

         DateFormat df = new SimpleDateFormat("d/M/YYYY");
         Calendar cal = Calendar.getInstance();
         Date presentday = cal.getTime();
         int year = cal.get(Calendar.YEAR);
         cal.set(year, 2, 31); // 31 March of Year
         Date marchFirstOfYear = cal.getTime();

         if (presentday.after(marchFirstOfYear)) {
        	 cal.set(year + 1, 2, 31);
             return df.format(cal.getTime());
         } else {
             return df.format(marchFirstOfYear);
     }
	 }
         
	
	
	/*
	 *  public static Date getFirstDateOfFinancialYear(Date dateToCheck) {
            int year = getYear(dateToCheck);
            Calendar cal = Calendar.getInstance();
            cal.set(year, 3, 1); // 1 April of Year
            Date firstAprilOfYear = cal.getTime();
    
            if (dateToCheck.after(firstAprilOfYear)) {
                return firstAprilOfYear;
            } else {
                cal.set(year - 1, 3, 1);
                return cal.getTime();
            }
        }
	 */
}
