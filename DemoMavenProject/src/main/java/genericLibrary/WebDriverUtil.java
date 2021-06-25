package genericLibrary;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtil {
	WebDriver driver;

	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}
	public void switchToSpecificTittleWindow(String title) {
		String parentwid = driver.getWindowHandle();
		Set<String> allwids = driver.getWindowHandles();
		allwids.remove(parentwid);
		for (String sessionId : allwids) {
			driver.switchTo().window(sessionId);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}

	public String switchToSpecificWindow(WebElement ele) {
		String parentwid = driver.getWindowHandle();
		Set<String> allwids = driver.getWindowHandles();
		allwids.remove(parentwid);
		for (String sessionId : allwids) {
			driver.switchTo().window(sessionId);
			if (ele.isDisplayed()) {
				break;
			}
		}
		return parentwid;
	}
	
}
