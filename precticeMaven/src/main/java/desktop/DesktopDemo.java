package desktop;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class DesktopDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		File f = new File("C:\\Users\\acer\\Desktop\\HtmlReport\\HtmlReport_2023-02-13-18-01-53\\TestReport.html");
		File fn = new File("C:\\Users\\acer\\Desktop\\2159650-ECard.pdf");
		Desktop d =  Desktop.getDesktop();
		d.open(fn);
		
	}

}
