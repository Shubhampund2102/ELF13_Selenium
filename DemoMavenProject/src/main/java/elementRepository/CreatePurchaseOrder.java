package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePurchaseOrder {
	public CreatePurchaseOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement AddVenderName;

	@FindBy(xpath="//a[text()='Susan']")
	private WebElement VenderName;
	
	@FindBy(xpath="//a[text()='Life Style']")
	private WebElement VenderName1;
	
	@FindBy(xpath="//a[text()='Mary']")
	private WebElement VenderName2;
	
	public WebElement getVenderName1() {
		return VenderName1;
	}
	@FindBy(xpath="//select[@name='postatus']")
	private WebElement POstatus;
	
	@FindBy(xpath="//input[@name='subject']")
	private WebElement Subject;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAddress;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingAddress;
	
	@FindBy(id="searchIcon1")
	private WebElement item;
	
	@FindBy(xpath="//a[text()='Double Panel See-thru Clipboard']")
	private WebElement itemName;
	
	@FindBy(id="qty1")
	private WebElement quantity;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[contains(text(),'Purchase Order Information')]/..")
	private WebElement confirmationElement;

	public WebElement getConfirmationElement() {
		return confirmationElement;
	}

	public WebElement getAddVenderName() {
		return AddVenderName;
	}

	public WebElement getVenderName() {
		return VenderName;
	}

	public WebElement getPOstatus() {
		return POstatus;
	}

	public WebElement getSubject() {
		return Subject;
	}

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	public WebElement getShippingAddress() {
		return shippingAddress;
	}

	public WebElement getItem() {
		return item;
	}

	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getVenderName2() {
		return VenderName2;
	}	
	
}
