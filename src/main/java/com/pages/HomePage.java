package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ActionDriver;

public class HomePage {
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menubutton;
	@FindBy(css="div.bm-menu a")
	private List<WebElement> homemenulist;
	@FindBy(xpath="//span[@class='title']")
	private WebElement productlogo;
    private WebDriver driver;
    private ActionDriver action=new ActionDriver();;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	public void clickOnMenu()
	{
		action.clickOnElement(menubutton);
		
	}
	public int getHomeMenuLinksCount()
	{
		return homemenulist.size();
	}
	public List<String> getHomemenulist()
	{
		List<String> homeList=new ArrayList<>();
		System.out.println(homemenulist.size());
		System.out.println("text at first place is " +homemenulist.get(0).getText());
			for(WebElement e:homemenulist)
		
		{
			String text=e.getText();
			System.out.println(text);
			homeList.add(text);
		}
		
		return homeList;
		
	}
	public boolean isProductLogoDisplayed()
	{
		if(productlogo.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	public String getProductLogoText() {
		
		return productlogo.getText();
	}

}
