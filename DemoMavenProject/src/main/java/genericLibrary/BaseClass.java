package genericLibrary;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import elementRepository.Home;
import elementRepository.Login;

public class BaseClass implements IAutoConstants{
	public WebDriver driver;
    
	@BeforeClass
	public void beforeClass() {
		//Reporter.log("beforeClass",true);	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		//Reporter.log("beforMethod",true);
		driver.get(URL);
		Assert.assertEquals(driver.getTitle(), Login_PageTitle, "Login page is Not Displaying");
        Login login=new Login(driver);
		login.getUsernameTextField().sendKeys(Username);
		Assert.assertEquals(login.getUsernameTextField().getAttribute("value"), Username, "Username is Not Entered");
		login.getPasswordTextField().sendKeys(Password);
		Assert.assertEquals(login.getPasswordTextField().getAttribute("value"), Password, "Password is Not Entered");
		login.getLoginButton().click();
		Assert.assertEquals(driver.getTitle(), Home_PageTitle,"Home page is Not Displaying");
	}
	
	@AfterMethod
	public void afterMethod() {
		//Reporter.log("afterMethod",true);
		Home home=new Home(driver);
		Actions actions= new Actions(driver);
		actions.moveToElement(home.getProfile()).perform();
		home.getSignOutLink().click();		
	}
	
	@AfterClass
	public void AfterClass() {
		//Reporter.log("AfterClass",true);
		driver.quit();
	} 
	
	@BeforeTest
	public void beforeTest() {
		//Reporter.log("beforeTest",true);
	}
	@AfterTest
	public void afterTest() {
		//Reporter.log("afterTest",true);
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		//Reporter.log("beforeSuite",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		//Reporter.log("afterSuite",true);
	}
}
