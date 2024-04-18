package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEX
{
	@Test(dataProvider = "data")
	public void getData(String name,String place)
	{
		System.out.println(name+"--->"+place);
	}
	
	
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] ob=new Object[2][2];
		
		ob[0][0]="Mounika";
		ob[0][1]="ATP";
		
		ob[1][0]="Akkiraju";
		ob[1][1]="bglr";
		
		return ob;
	}

//	@DataProvider
//	public Object[][] data1()
//	{
//		Object[][] obj= new Object[3][];
//		
//		obj[0][0]="renu";
//		obj[0][1]="up";
//		
//		return obj;
//	}
	
	

}
