package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createNewVender;
	
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement venderNameTextFiled;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCreateNewVender() {
		return createNewVender;
	}

	public WebElement getVenderNameTextFiled() {
		return venderNameTextFiled;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
}
