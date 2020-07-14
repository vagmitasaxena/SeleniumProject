package RetailProject;

//To Verify whether application allows admin to add multiple product by entering valid credentials in mandatory fields only, using data in excel sheet.

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.AddMultipleProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddMultipleProduct {
	private WebDriver driver;
	private String baseUrl;
	private AddMultipleProductPOM AddMultipleProductPOM;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/admin.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AddMultipleProductPOM = new AddMultipleProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void multipleProductAdd(String ProductName, String MetaTitle, String Model, String Price, String Quantity, String Category) throws InterruptedException{
		//Add multiple product
		AddMultipleProductPOM.sendAdminUsername("admin"); //enter credentials in Username textbox
		AddMultipleProductPOM.sendAdminPassword("admin@123"); //enter credentials in Password textbox
		AddMultipleProductPOM.clickAdminLoginBtn(); //click on Login button
		Thread.sleep(3000);
		AddMultipleProductPOM.moveToCatelogMenuLink(); //Click on Catelog icon
		AddMultipleProductPOM.moveToProductLinkClick(); //Click on Products link
		AddMultipleProductPOM.clickAddNewProduct(); //Click on Add New icon
		if (!ProductName.isBlank()) {
		AddMultipleProductPOM.sendProductName(ProductName);} //Enter Valid data in Product Name text box of General tab
		if (!MetaTitle.isBlank()) {
		AddMultipleProductPOM.sendMetaTagTitle(MetaTitle);} //Enter Valid data in Meta Tag Title text box of General tab
		AddMultipleProductPOM.clickDataTab(); //Click on Data tab
		if (!Model.isBlank()) {
		AddMultipleProductPOM.sendModel(Model);} //Enter valid data in Model text box
		if (!Price.isBlank()) {
		AddMultipleProductPOM.sendPrice(Price);} //Enter valid data in Price text box
		if (!Quantity.isBlank()) {
		AddMultipleProductPOM.sendQuantity(Quantity);} //Enter valid data in Quantity text box
		AddMultipleProductPOM.clickLinksTab(); //Click on Links tab
		if (!Category.isBlank()) {
		AddMultipleProductPOM.sendCategory(Category);} //Click and select Category from displayed category list
		AddMultipleProductPOM.clickSaveBtn(); //Click on Save icon
		String actualSuccessMessage=AddMultipleProductPOM.successMessageDisplayed(); //Save message displayed for validation
		System.out.println(actualSuccessMessage);
        String expectedSuccessMessage="Success: You have modified products!\n" + "×"; //Expected Success message
		Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage); //Verify that appropriate success message should get displayed		
		}
}
