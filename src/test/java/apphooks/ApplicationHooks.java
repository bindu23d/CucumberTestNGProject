package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.BrowserFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private BrowserFactory browserfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	@Before(order=0)
	public void getProperty()
	{
		configreader=new ConfigReader();
		prop=configreader.loadConfig();
	}
	@Before(order=1)
	public void getBrowser()
	{
		String browserName=prop.getProperty("browser");
		System.out.println("Browser from property file is" +browserName );
		browserfactory=new BrowserFactory();
		driver=browserfactory.init_Driver(browserName);
		
		
	}
	
		@After(order=0)
		public void quitDriver()
		{
			driver.quit();
		}
		@After(order=1)
		public void tearDown(Scenario scenario)
		{
			if(scenario.isFailed())
			{
				String screenShotName=scenario.getName().replaceAll(" ", "_");
				byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath,"image/png", screenShotName);
			}
			
		}
		
	

}
