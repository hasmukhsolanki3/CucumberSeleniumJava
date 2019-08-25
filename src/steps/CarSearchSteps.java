package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarSearchSteps {
	
	public static WebDriver driver;
	
	@Before
	public void setUp(){
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	@After
	public void tearDown(Scenario scenario){
		
		/*if(scenario.isFailed()){
			byte[] screenshotBytes = ((TakesScreenshot)
					driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}*/
		
		if(driver != null)
			driver.quit();
	}

	@Given("^I am on Homepage of CarGuide site$")
	public void i_am_on_Homepage_of_CarGuide_site() throws Throwable {
	    
		driver.get("https://www.carsguide.com.au");
	    
	}

	@When("^I move to \"([^\"]*)\" Menu$")
	public void i_move_to_Menu(String arg1) throws Throwable {
	    
	    new Actions(driver).moveToElement(driver.findElement(By
	    		.cssSelector("#u_H > div > div.uhf-menu-left > ul > li:nth-child(1) > a"))).perform();
	}

	@When("^I click on Search Cars$")
	public void i_click_on_Search_Cars() throws Throwable {

		driver.findElement(By
				.cssSelector("#u_H > div > div.uhf-menu-left > ul > li:nth-child(1) > div > div > div:nth-child(1) > ul > li:nth-child(1) > a"))
				.click();
	    
	}

	@When("^I select Make as \"([^\"]*)\"$")
	public void i_select_Make_as(String make) throws Throwable {
	    
		Thread.sleep(3000);
	    new Select(driver.findElement(By.cssSelector("#makes"))).selectByVisibleText(make);
	}

	@When("^I select Model as \"([^\"]*)\"$")
	public void i_select_Model_as(String model) throws Throwable {
	    
		Thread.sleep(3000);
	    new Select(driver.findElement(By.cssSelector("#models"))).selectByVisibleText(model);
	}

	@When("^I select location as \"([^\"]*)\"$")
	public void i_select_location_as(String location) throws Throwable {
	    
		Thread.sleep(3000);
	    new Select(driver.findElement(By.cssSelector("#locations"))).selectByVisibleText(location);
	}

	@When("^I select price as \"([^\"]*)\"$")
	public void i_select_price_as(String price) throws Throwable {
	    
		Thread.sleep(3000);
	    new Select(driver.findElement(By.cssSelector("#price-max"))).selectByVisibleText(price);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
	    
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#search-submit")).click();
	    
	}

	@Then("^I should see list of searched cars from \"([^\"]*)\"$")
	public void i_should_see_list_of_searched_cars(String car) throws Throwable {
	    
		Assert.assertTrue(driver.findElement(By
				.cssSelector("#pos0 > div.carListing--content > div.carListing--text > div.carListing--textRow.carListing--titlePriceRow > div.carListing--textCol1 > h5"))
				.getText().contains(car));
	    
	}

	@Then("^the page title should be \"([^\"]*)\"$")
	public void the_page_title_should_be(String expected) throws Throwable {
	    
	    Assert.assertEquals(expected, driver.getTitle());
		
	}


}
