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

import com.training.pom.AddProductDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductDetails {
	private WebDriver driver;
	private String baseUrl;
	private AddProductDetailsPOM AddProductDetailsPOM;
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
		AddProductDetailsPOM = new AddProductDetailsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void AddProductInCart() throws InterruptedException {
   		AddProductDetailsPOM.moveToShopLink();
		Thread.sleep(3000);
		AddProductDetailsPOM.moveToEthnicLinkClick();
		AddProductDetailsPOM.moveToItemLink();
		AddProductDetailsPOM.moveToSelectedItemLinkClick();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		AddProductDetailsPOM.moveToAddToCartLinkClick();
		Thread.sleep(3000);
	    driver.navigate().refresh();
	    AddProductDetailsPOM.moveToCartItemsLink();
		driver.findElement(By.linkText("View Cart")).click();
		Boolean actualResult=driver.findElement(By.xpath("//div[@class='cart-info tb_min_w_500']//table/tbody/tr/td[2]/a")).isDisplayed();
		Boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult);
 	}
}
