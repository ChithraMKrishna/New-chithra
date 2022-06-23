import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class SystemDateTest {

	public static void main(String[] args) 
	{
		//WebDriver web=null;
			Date date=new Date();
			String value = date.toString();
			System.out.println(value);
			
			
		
				Date date1=new Date();
				SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
				String formatter = format.format(date1);
				System.out.println(formatter);
		
				
				Date date3=new Date();
				String yyyy = value.split(" ")[5];
				String mm = value.split(" ")[1];
				String dd = value.split(" ")[2];
				String finalformat = yyyy+"-"+mm+"-"+dd;
				System.out.println(finalformat);
			

	}

}
