package javaPractice;

import java.util.Date;
import java.util.Scanner;

//import org.openqa.selenium.devtools.v107.runtime.model.TimeDelta;

public class StopWatch {
	
	public static void main(String[] args) {
		String value;
		long startTime = 0, endTime = 0,  duration = 0;
		boolean running= false;
		System.out.println("StopWatch \n 1.Start \n 2.Stop \n 3.Quit \r\n");
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
	
        value = read.next();
        
		
		while(!(value.equalsIgnoreCase("quit"))) {
			
		if (value.equalsIgnoreCase("start")) {
			
			if (running) {
				System.out.println("already runing");
				
			} else {
				running = true;
				startTime = System.currentTimeMillis();

				System.out.println("started " + startTime);
			}
			
		}
		
		else if (value.equalsIgnoreCase("stop")) {
			
			if (!running) {
				System.out.println("not runing");
				
			} else {
				running = false;
				endTime = System.currentTimeMillis();
				System.out.println("stoped " + endTime);
				break;

			}
			
		}

		 value = read.next();
			
		}
		
		duration = endTime - startTime;
		System.out.println((float) duration/1000);
		System.out.println("ended");
	}

}
