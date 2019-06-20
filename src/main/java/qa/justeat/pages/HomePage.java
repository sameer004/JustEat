package qa.justeat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.justeat.base.TestBase;

 

public class HomePage extends TestBase{
	 

	@FindBy(linkText = "UK")
	WebElement Destinations;
	
	@FindBy(name="postcode")
	WebElement search_box;
	 
	@FindBy(xpath="//*[@id=\"skipToMain\"]/div/h1/span[1]")
	WebElement total_resturants;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		
		return driver.getTitle();
	
	}
	
	public void Select_destination(){
	Destinations.click();
	}
	
	 
	
	public void Select_for_resturants(String postcode){
		search_box.sendKeys(postcode);
		}
	
	
	public void Click_search(){
		 search_box.submit();
		}
	
	public String Total_resturants() {
		return total_resturants.getText();
	}
	
}
