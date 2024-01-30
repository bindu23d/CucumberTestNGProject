package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.BrowserFactory;
import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private LoginPage loginpage=new LoginPage(BrowserFactory.getDriver());
	private HomePage homepage;
	private ConfigReader configreader;
	private Properties prop;
	@Given("User has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable creddataTable) {
		List<Map<String,String>> credList=creddataTable.asMaps();
		String userName=credList.get(0).get("uid");
		String password=credList.get(0).get("pwd");
		configreader=new ConfigReader();
		prop=configreader.loadConfig();
		String url=prop.getProperty("url");
		System.out.println("hello the driver is" +BrowserFactory.getDriver());
		BrowserFactory.getDriver().get(url);
		homepage=loginpage.loginToApp(userName, password);
		
	}

	@When("User gets the logo text of the Home Page")
	public void user_gets_the_logo_text_of_the_home_page() {
		String logoText=homepage.getProductLogoText();
		System.out.println("The home page logo text is "+ logoText);
	    
	}

	@When("User click on menu button on top left")
	public void user_click_on_menu_button_on_top_left() {
		homepage.clickOnMenu();
	    
	}

	@Then("User gets menu item links")
	public void user_gets_menu_item_links(DataTable itemLinksTable) {
		List<String> expMenuLinks=itemLinksTable.asList();
		System.out.println("Expected links are "+expMenuLinks);
		List<String> actualMenuLinks=homepage.getHomemenulist();
		System.out.println("Actual links are "+actualMenuLinks);
		Assert.assertTrue(expMenuLinks.containsAll(actualMenuLinks));
		    
	}

	@Then("Links count should be {int}")
	public void links_count_should_be(Integer expectedLinksCount) {
		Assert.assertTrue(homepage.getHomeMenuLinksCount()==expectedLinksCount);
	   
	}

}
