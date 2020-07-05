package RetailProject;

//Objective: To verify whether application allows admin to add category in categories page

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategory {
	private WebDriver driver;
	private String baseUrl;
	private AddCategoryPOM AddCategoryPOM;
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
		AddCategoryPOM = new AddCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void addCategoryTest() throws InterruptedException {
		//Add new category test
		AddCategoryPOM.sendAdminUsername("admin"); //enter credentials in Username textbox
		AddCategoryPOM.sendAdminPassword("admin@123"); //enter credentials in Password textbox
		AddCategoryPOM.clickAdminLoginBtn(); //click on Login button
		Thread.sleep(3000);
		AddCategoryPOM.moveToCategoryMenuLink(); //Click on Catelog icon
    	AddCategoryPOM.moveToCategoryLinkClick(); //Click on Categories link
    	AddCategoryPOM.moveToAddCategoryLinkClick(); //Click on Add new icon
    	AddCategoryPOM.sendNewCategoryName("ETHNICORNAMENTS"); //Enter new Category Name in the textbox of General tab
    	AddCategoryPOM.sendNewCategoryDescription("ornaments for ladies"); //Enter new Category description in the textbox of General tab
    	AddCategoryPOM.sendNewMetaTagTitle("ETHNICORNAMENTS"); //Enter new Meta tag title in the textbox of General tab
    	AddCategoryPOM.sendNewMetaTagDescription("ornaments for ladies"); //Enter new Meta tag description in the textbox of General tab
    	AddCategoryPOM.clickSaveBtn(); //Save the new Category by clicking save icon
    	String actualResult = AddCategoryPOM.alertSuccessMessage();
		System.out.println(actualResult);
    	String expectedResult="Success: You have modified categories!\n" + "×";
    	Assert.assertEquals(actualResult,expectedResult); //Verify that appropriate success message should get displayed
	}
}
