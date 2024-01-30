package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.BrowserFactory;
import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private LoginPage loginpage=new LoginPage(BrowserFactory.getDriver());
    private Properties prop;
	private String loginPagetitle;
	private ConfigReader configreader;
	@Given("User is on login page")
	public void user_is_on_login_page(){
		configreader=new ConfigReader();
		prop=configreader.loadConfig();
		String url=prop.getProperty("url");
		System.out.println("hello the driver is" +BrowserFactory.getDriver());
		BrowserFactory.getDriver().get(url);
	    
	}
	@When("I get the title of Login Page")
	public void i_get_the_title_of_login_page() {
	    
	  
		loginPagetitle=loginpage.getLoginPageTitle();
	}

	@Then("Login Page title should be {string}")
	public void login_page_title_should_be(String expectedTitle) {
		//System.out.print("Login page titile is "+ loginPagetitle);
	    Assert.assertEquals(loginPagetitle,expectedTitle);
	}


	@When("I enter userid and password")
	public void i_enter_userid_and_password(DataTable creddataTable) {
		List<Map<String,String>> credList=creddataTable.asMaps();
		String userName=credList.get(0).get("uid");
		String password=credList.get(0).get("pwd");
		
        loginpage.enterUserId(userName);
		
		loginpage.enterPassword(password);
		//Thread.sleep(7000);
	}
	@When("Click on Login button")
	public void click_on_login_button()
	{
		loginpage.clickButton();
		
	}

	

	@Then("Home page should appear with logo {string}")
	public void home_page_should_appear_with_logo(String expectedLogoTitle) {
		//System.out.print("home page logo is "+ loginpage.logoText());
		Assert.assertEquals(loginpage.homelogoText(),expectedLogoTitle);
	   
	}
	@When("I enter wrong userid {string} and password {string}")
	public void i_enter_wrong_userid_and_password(String uid,String pwd) {
    loginpage.enterUserId(uid);
		
    loginpage.enterPassword(pwd);
   // Thread.sleep(7000);
	}

	@When("I click on Login button")
	public void i_click_on_login_button() {
		loginpage.clickButton();
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {
	    Assert.assertTrue(loginpage.isErrorMessageDisplayed());
	}


	

}
