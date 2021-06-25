package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Purchase Order']")
	private WebElement PurchaseOrder;
	
	public WebElement getCreateNewPurchaseOrder() {
		return CreateNewPurchaseOrder;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Profile;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(xpath="//td[text()='Vendor Name']/..//a")
	private WebElement VenderName;

	public WebElement getVenderName() {
		return VenderName;
	}

	public WebElement getProfile() {
		return Profile;
	}


	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	@FindBy(xpath="//img[@alt='Create Purchase Order...']")
	private WebElement CreateNewPurchaseOrder;
	

	public WebElement getPurchaseOrder() {
		return PurchaseOrder;
	}

}
