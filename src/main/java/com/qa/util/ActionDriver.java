package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.BrowserFactory;

public class ActionDriver {
	

private WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(10));
	
	public  void waitForVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public  void waitForElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void clickOnElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}

	public void sendKeysTo(WebElement element, String text){
		waitForVisible(element);
		element.clear();
		element.sendKeys(text);
	}
	
	

}
