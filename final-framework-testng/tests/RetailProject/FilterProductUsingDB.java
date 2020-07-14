package RetailProject;

//To Verify whether application allows the admin to filter the product details with multiple values using data in Database.

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.FilterProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterProductUsingDB {
	private WebDriver driver;
	private String baseUrl;
	private FilterProductPOM FilterProductPOM;
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
		FilterProductPOM = new FilterProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void multipleProductFilterDB(String ProductName, String Price, String Status, String Model, String Quantity, String Image) throws InterruptedException{
		//Add multiple product filter
		FilterProductPOM.sendAdminUsername("admin"); //enter credentials in Username textbox
		FilterProductPOM.sendAdminPassword("admin@123"); //enter credentials in Password textbox
		FilterProductPOM.clickAdminLoginBtn(); //click on Login button
		Thread.sleep(3000);
		FilterProductPOM.moveToCatelogMenuLink(); //Click on Catelog icon
		FilterProductPOM.moveToProductLinkClick(); //Click on Products link
		if (!ProductName.isBlank()) {
		FilterProductPOM.sendProductName(ProductName);} //Enter valid data in Product Name textbox
		if (!Price.isBlank()) {
		FilterProductPOM.sendPrice(Price);} //Enter valid data in Price textbox
		if ((!ProductName.isBlank()) || (!Price.isBlank())) {
		FilterProductPOM.clickFilterBtn();} //Click filter button
		if (!Status.isBlank()) {
		FilterProductPOM.clickStatus(); //Click Status
		FilterProductPOM.selectStatus(Status);} //Select values from Status list box
		if (!Model.isBlank()) {
		FilterProductPOM.sendModel(Model);} //Enter valid data in Model textbox
		if (!Quantity.isBlank()) {
		FilterProductPOM.sendQuantity(Quantity);} //Enter valid data in Quantity textbox
	    if (!Image.isBlank()) {
		FilterProductPOM.clickImage(); //Click Image 
		FilterProductPOM.selectImage(Image);} //Select values from Image list box
	    if ((!Status.isBlank()) || (!Model.isBlank()) || (!Quantity.isBlank()) || (!Image.isBlank())) {
		FilterProductPOM.clickFilterBtn();} //Click filter button
	}
}
