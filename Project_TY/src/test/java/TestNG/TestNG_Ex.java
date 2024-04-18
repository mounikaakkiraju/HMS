package TestNG;

import org.testng.annotations.Test;


public class TestNG_Ex
{
	@Test(priority = 0)
	public void method1()
	{
		System.out.println("---Method 1----");
	}
	
	@Test(invocationCount = 2)
	public void Method2()
	{
		System.out.println("---Method  2----");
	}
	
	@Test(priority = -1)
	public void method3()
	{
		System.out.println("---Method 3----");
	}

}
