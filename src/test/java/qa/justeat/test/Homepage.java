package qa.justeat.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.justeat.base.TestBase;
import qa.justeat.pages.HomePage;

public class Homepage extends TestBase {

	HomePage homepage;

	public Homepage() {
		super();

	}

	@BeforeMethod
	public void testsetup() {
		initialization();
		homepage = new HomePage();

	}

	@Test(priority = 1)
	public void verfify_landing_page() {
	 
		assertEquals(homepage.verifyHomePageTitle(),"Order takeaway online from 30,000+ food delivery restaurants | Just Eat");
	}

	@Test(priority = 2)
	public void search_by_postCode() {
	 homepage.Select_for_resturants("AR51 1AA");
	 homepage.Click_search();
	 System.out.println(homepage.Total_resturants());

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
