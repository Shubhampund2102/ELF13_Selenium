package PurchaseOrder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import elementRepository.CreatePurchaseOrder;
import elementRepository.Home;
import genericLibrary.BaseClass;
import genericLibrary.ExcelUtil;
import genericLibrary.ListenerImplementation;
import genericLibrary.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class TC_001Test extends BaseClass{
	@Test
	public void createPurchaseOrder() throws Exception {
		WebDriverUtil webDriverUtil=new WebDriverUtil(driver);
		Actions actions=new Actions(driver);

		//==================================Step 1: Click on Purchase Order Link=========================================
		actions.moveByOffset(910, 60).perform();
		Home home=new Home(driver);
		home.getPurchaseOrder().click();
		Assert.assertEquals(driver.getTitle(), PurchaseOrder_PageTitle,"Purchase Order page is Not Displaying");

		//==================================Step 2: Click on Create new Purchase Order Link=============================== 
		home.getCreateNewPurchaseOrder().click();
		Assert.assertEquals(driver.getTitle(), CreateNewPurchaseOrder_PageTitle,"Create New Purchase Order page is Not Displaying");

		//==================================Step 3: Create Purchase Order with mandatory fields=====================
		CreatePurchaseOrder createPurchaseOrder =new CreatePurchaseOrder(driver);
		ExcelUtil ex=new ExcelUtil();
		String subject=ex.getStringCellValue(ExcelFile_path, "Sheet1", 0,0);
		createPurchaseOrder.getSubject().sendKeys(subject);
		Assert.assertEquals(createPurchaseOrder.getSubject().getAttribute("value"),subject,"Subject is Not Entered");

		createPurchaseOrder.getAddVenderName().click();
		String parentwid=webDriverUtil.switchToSpecificWindow(createPurchaseOrder.getVenderName());
		createPurchaseOrder.getVenderName().click();
		driver.switchTo().window(parentwid);

		Select select=new Select(createPurchaseOrder.getPOstatus());
		select.selectByValue("Created");

		String billingAddress=ex.getStringCellValue(ExcelFile_path, "Sheet1", 1,0);
		createPurchaseOrder.getBillingAddress().sendKeys(billingAddress);
		SoftAssert asert=new SoftAssert();
		asert.assertEquals(createPurchaseOrder.getBillingAddress().getAttribute("value"),billingAddress,"Billing Address is Not Entered");

		String shippingAddress=ex.getStringCellValue(ExcelFile_path, "Sheet1", 2,0);
		createPurchaseOrder.getShippingAddress().sendKeys(shippingAddress);
		asert.assertEquals(createPurchaseOrder.getShippingAddress().getAttribute("value"),shippingAddress,"Shipping Address is Not Entered");

		createPurchaseOrder.getItem().click();
		webDriverUtil.switchToSpecificWindow(createPurchaseOrder.getItemName());
		createPurchaseOrder.getItemName().click();
		driver.switchTo().window(parentwid);

		int quantity=ex.getIntegerNumericCellValue1(ExcelFile_path, "Sheet1", 3,0);
		createPurchaseOrder.getQuantity().sendKeys(""+quantity+"");
		Assert.assertEquals(createPurchaseOrder.getQuantity().getAttribute("value"),""+quantity+"","Item is Not Entered");

		//=====================================Step 4: Click on Save Button=======================================================
		createPurchaseOrder.getSaveButton().click();

		//=====================================Step 5: Display Congirmation Message================================================
		String confirmationMessage=createPurchaseOrder.getConfirmationElement().getText();
		Reporter.log(confirmationMessage,true);

		//asert.assertAll();
	}
}
