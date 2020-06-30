package RetailProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.PasswordValidationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PasswordValidation {
	private WebDriver driver;
	private String baseUrl;
	private PasswordValidationPOM PasswordValidationPOM;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		PasswordValidationPOM = new PasswordValidationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
     //   WebElement accountLink=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
     //  Actions act=new Actions(driver);
	 //	 act.moveToElement(accountLink).build().perform();
	//	WebElement loginLink=driver.findElement(By.xpath("//li[@class='tb_link tb_menu_system_account_login']"));
	//	act.moveToElement(loginLink).click().build().perform();
		PasswordValidationPOM.moveToAccountLink();
		Thread.sleep(3000);
		PasswordValidationPOM.moveToLoginLinkClick();	
		PasswordValidationPOM.sendUserEmail("sar_elec@yahoo.com");
		PasswordValidationPOM.sendUserEmailPassword("sarita");
		PasswordValidationPOM.clickEmailLoginBtn();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Change your password")).click();
		PasswordValidationPOM.sendUserEmailPassword("manipal");
		PasswordValidationPOM.sendUserEmailConfirmPassword("manip");
		PasswordValidationPOM.clickEmailLoginBtn();
		String actualResult = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		System.out.println(actualResult);
		String expectedResult="Password confirmation does not match password!";
		Assert.assertEquals(actualResult,expectedResult);
	}
}
