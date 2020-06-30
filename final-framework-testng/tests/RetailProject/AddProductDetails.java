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
    //    WebElement shopLink=driver.findElement(By.id("menu_all_categories_Menu_VIfWm2LT_VLHXC"));
	//	Actions act=new Actions(driver);
	//	act.moveToElement(shopLink).build().perform();
	//	WebElement ethnicLink=driver.findElement(By.xpath("//li[@class='tb_menu_category_VLHXC tb_link']"));
	//	act.moveToElement(ethnicLink).click().build().perform();
    //	WebElement ItemLink=driver.findElement(By.xpath("//a[contains(text(),'Integer vitae iaculis massa')]"));
	//	act.moveToElement(ItemLink).build().perform();
	//	WebElement ItemLink=driver.findElement(By.xpath("//a[contains(text(),'Integer vitae iaculis massa')]"));
	//	act.moveToElement(ItemLink).build().perform();
	//	WebElement SelectedItemLink=driver.findElement(By.xpath("//div[@id='ProductsSystem_QQI8r357']/div[1]/div[2]/div/div[2]/div[2]/a/span"));
	//	act.moveToElement(SelectedItemLink).click().build().perform();
		AddProductDetailsPOM.moveToShopLink();
		Thread.sleep(3000);
		AddProductDetailsPOM.moveToEthnicLinkClick();
		AddProductDetailsPOM.moveToItemLink();
		AddProductDetailsPOM.moveToSelectedItemLinkClick();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
	//	WebElement addToCart=driver.findElement(By.xpath("//button[@id='button-cart']"));
	//	act.moveToElement(addToCart).click().build().perform();
		AddProductDetailsPOM.moveToAddToCartLinkClick();
		Thread.sleep(3000);
	    driver.navigate().refresh();
	 //   WebElement CartItems=driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
	//	act.moveToElement(CartItems).build().perform();
	    AddProductDetailsPOM.moveToCartItemsLink();
		driver.findElement(By.linkText("View Cart")).click();
		Boolean actualResult=driver.findElement(By.xpath("//div[@class='cart-info tb_min_w_500']//table/tbody/tr/td[2]/a")).isDisplayed();
		Boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult);
 	}
}
