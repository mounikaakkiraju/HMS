package Project_ObjectRepository;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListenersImplimentationClass.class)
public class NewTest extends BaseClass{

	
	@Test
	public void newtest()
	{
		System.out.println("---- print ----");
		Assert.fail();
		System.out.println("---- print 2----");
	}
}
