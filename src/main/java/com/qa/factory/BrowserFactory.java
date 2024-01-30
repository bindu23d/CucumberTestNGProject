package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	//public static WebDriver driver;
	//public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	public WebDriver init_Driver(String browser)
	{
		System.out.println("Browser is  " + browser);
        if (browser.equalsIgnoreCase("Chrome")) {
        	//driver=new ChromeDriver();
			
			tlDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("FireFox")) {
			//driver=new FirefoxDriver();
			
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("IE")) {
			//driver=new InternetExplorerDriver();
			
			tlDriver.set(new InternetExplorerDriver());
		}
		else {
			System.out.println("Please enter the correct browser value");
		}
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        
        return getDriver();
		
	}
	public static synchronized WebDriver getDriver()
	{
		//return driver;
		return tlDriver.get();
	}
	}
	


