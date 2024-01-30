package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ActionDriver;



public class LoginPage {
	@FindBy(name="user-name")
	private WebElement userid;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(id="login-button")
	private WebElement loginbutton;
	@FindBy(xpath="//span[@class='title']")
	private WebElement productlogo;
	@FindBy(xpath="//div[@class='error-message-container error']")
	private WebElement errorMessageContainer;
	
	
	private WebDriver driver;
	private ActionDriver action=new ActionDriver();;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUserId(String uid) {
		
		action.sendKeysTo(userid, uid);
		//userid.sendKeys(uid);
		
	}
public void enterPassword(String pwd) {
	action.sendKeysTo(password, pwd);
		
		//password.sendKeys(pwd);
		
	}
public void clickButton()
{
	action.clickOnElement(loginbutton);
	  // loginbutton.click();
	}


public String homelogoText() {
	
	return productlogo.getText();
}
public boolean isErrorMessageDisplayed()
{
	if(errorMessageContainer.isDisplayed())
	{
		return true;
	}
	else
		return false;
}


public String errorText() {
	
	return errorMessageContainer.getText();
}
public HomePage loginToApp(String uid,String pwd)
{
	action.sendKeysTo(userid, uid);
    action.sendKeysTo(password, pwd);
    action.clickOnElement(loginbutton);
	//userid.sendKeys(uid);
	//password.sendKeys(pwd);
	//loginbutton.click();
	return new HomePage(driver);
	}

}
