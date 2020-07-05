package RetailProject;

//Objective: To verify whether application denies admin getting logged in upon entering invalid credentials in required field

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminPasswordValidation {
	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM AdminLoginPOM;
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
		AdminLoginPOM = new AdminLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validAdminLoginTest() throws InterruptedException {
		//Validate admin Login
		AdminLoginPOM.sendAdminUsername("admin"); //enter credentials in Username textbox
		AdminLoginPOM.sendAdminPassword("admin"); //enter credentials in Password textbox
		AdminLoginPOM.clickAdminLoginBtn(); //click on Login button
		Thread.sleep(3000);
		String actualResult = AdminLoginPOM.alertMessageAdminLogin();
		System.out.println(actualResult);
		String expectedResult="No match for Username and/or Password.\n" + "×";
		Assert.assertEquals(actualResult,expectedResult); //Verify that appropriate Error message should get displayed for wrong admin password
	}
}
