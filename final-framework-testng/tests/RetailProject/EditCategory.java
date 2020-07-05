package RetailProject;

//To verify whether application allows admin to Edit Meta tag Title in categories page

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.EditCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditCategory {
	private WebDriver driver;
	private String baseUrl;
	private EditCategoryPOM EditCategoryPOM;
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
		EditCategoryPOM = new EditCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void editCategoryTest() throws InterruptedException {
		//Edit category test
		EditCategoryPOM.sendAdminUsername("admin"); //enter credentials in Username textbox
		EditCategoryPOM.sendAdminPassword("admin@123"); //enter credentials in Password textbox
		EditCategoryPOM.clickAdminLoginBtn(); //click on Login button
		Thread.sleep(3000);
		EditCategoryPOM.moveToCategoryMenuLink(); //Click on Catelog icon
		EditCategoryPOM.moveToCategoryLinkClick(); //Click on Categories link
		EditCategoryPOM.selectCategoryToEdit("ETHNICORNAMENTS");//Select Category to edit
		Thread.sleep(3000);
		EditCategoryPOM.clickEditLink();//Click on Edit link
		EditCategoryPOM.sendNewMetaTagTitle("ETHNICORNAMENTSNEW"); //Enter new Meta tag title in the textbox of General tab
		EditCategoryPOM.sendNewMetaTagDescription("New ornaments for ladies"); //Enter new Meta tag description in the textbox of General tab
		EditCategoryPOM.clickSaveBtn(); //Save the new Category by clicking save icon
    	String actualResult = EditCategoryPOM.alertSuccessMessage();
  		System.out.println(actualResult);
    	String expectedResult="Success: You have modified categories!\n" + "×";
    	Assert.assertEquals(actualResult,expectedResult); //Verify that appropriate success message should get displayed
	}
}
