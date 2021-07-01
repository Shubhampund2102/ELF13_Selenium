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
import elementRepository.ProductPage;
import genericLibrary.BaseClass;
import genericLibrary.ExcelUtil;
import genericLibrary.ListenerImplementation;
import genericLibrary.WebDriverUtil;
@SuppressWarnings("unused")
@Listeners(ListenerImplementation.class)
public class TC_004Test extends BaseClass {
	@Test
	public void CreateNewProduct() throws Exception {

		WebDriverUtil webDriverUtil=new WebDriverUtil(driver);
		Actions actions=new Actions(driver);

		//===============================Step 1: Click on Purchase Order Link=======================================

		actions.moveByOffset(910, 60).perform();
		Home home=new Home(driver);
		home.getPurchaseOrder().click();
		Assert.assertEquals(driver.getTitle(), PurchaseOrder_PageTitle,"Purchase Order page is Not Displaying");

		//================================Step 2: Click on Create new Purchase Order Link============================

		home.getCreateNewPurchaseOrder().click();
		Assert.assertEquals(driver.getTitle(), CreateNewPurchaseOrder_PageTitle,"Create New Purchase Order page is Not Displaying");

		//============================Step 3: Create a Purchase Order with mandatory fields====================================
		CreatePurchaseOrder createPurchaseOrder =new CreatePurchaseOrder(driver);
		ExcelUtil ex=new ExcelUtil();


		String subject=ex.getStringCellValue(ExcelFile_path, "Sheet4", 0,0);
		createPurchaseOrder.getSubject().sendKeys(subject);
		Assert.assertEquals(createPurchaseOrder.getSubject().getAttribute("value"),subject,"Subject is Not Entered");

		createPurchaseOrder.getAddVenderName().click();
		String parentwid=webDriverUtil.switchToSpecificWindow(createPurchaseOrder.getVenderName2());
		createPurchaseOrder.getVenderName2().click();
		driver.switchTo().window(parentwid);

		Select select=new Select(createPurchaseOrder.getPOstatus());
		select.selectByValue("Created");

		String billingAddress=ex.getStringCellValue(ExcelFile_path, "Sheet4", 1,0);
		createPurchaseOrder.getBillingAddress().sendKeys(billingAddress);
		SoftAssert asert=new SoftAssert();
		asert.assertEquals(createPurchaseOrder.getBillingAddress().getAttribute("value"),billingAddress,"Billing Address is Not Entered");

		String shippingAddress=ex.getStringCellValue(ExcelFile_path, "Sheet4", 2,0);
		createPurchaseOrder.getShippingAddress().sendKeys(shippingAddress);
		asert.assertEquals(createPurchaseOrder.getShippingAddress().getAttribute("value"),shippingAddress,"Shipping Address is Not Entered");

		createPurchaseOrder.getItem().click();
		webDriverUtil.switchToSpecificWindow(createPurchaseOrder.getItemName());
		driver.switchTo().window(parentwid);

		//=======================================Step 4: Click on Product Page ======================================================
	
		createPurchaseOrder.getProductLink().click();
		ProductPage productPage=new ProductPage(driver);
		productPage.getCreateNewProductButton().click();
		String newProductName = ex.getStringCellValue(ExcelFile_path, "Sheet4", 3,0);
		productPage.getProductNameTextField().sendKeys(newProductName);
		productPage.getSaveButton().click();
		productPage.getCreateNewPurchaseOrderLink().click();
		Assert.assertEquals(driver.getTitle(), CreateNewPurchaseOrder_PageTitle,"Create New Purchase Order page is Not Displaying");
		String selectedProductName = createPurchaseOrder.getProductNameTextField().getAttribute("value");
		Reporter.log("Selected Product Name :"+selectedProductName,true);
				
	}
}
