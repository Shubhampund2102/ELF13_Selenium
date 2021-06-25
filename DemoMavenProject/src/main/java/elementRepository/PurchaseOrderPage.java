package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Vendor Name']/..//a[text()='Mary']")
	private WebElement selectdVender;
	
	public WebElement getSelectdVender() {
		return selectdVender;
	}
}
