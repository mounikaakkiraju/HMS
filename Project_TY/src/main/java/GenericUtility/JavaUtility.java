package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt();
		return random;
	}
	
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	public String uniqueMail(String mail)
	{
		Random ran=new Random();
		int random=ran.nextInt(1000);
		String[] a = mail.split("@");
		String email=a[0]+random+"@"+a[1];
		return email;
		
	}
    
	public String getSystemDateFormat()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		String sysDateInFormat=dateFormat.format(dt);
		return sysDateInFormat;
	}
	
}
