package RetailProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductDetails {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	//	driver.quit();
	}
	@Test
	public void AddProductInCart() throws InterruptedException {
        WebElement shopLink=driver.findElement(By.id("menu_all_categories_Menu_VIfWm2LT_VLHXC"));
		Actions act=new Actions(driver);
		act.moveToElement(shopLink).build().perform();
		Thread.sleep(3000);
		WebElement ethnicLink=driver.findElement(By.xpath("//li[@class='tb_menu_category_VLHXC tb_link']"));
		act.moveToElement(ethnicLink).click().build().perform();
		WebElement ItemLink=driver.findElement(By.xpath("//a[contains(text(),'Integer vitae iaculis massa')]"));
		act.moveToElement(ItemLink).build().perform();
		WebElement SelectedItemLink=driver.findElement(By.xpath("//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[2]/div/div[2]/div[2]/a/span"));
		act.moveToElement(SelectedItemLink).click().build().perform();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement addToCart=driver.findElement(By.xpath("//button[@id='button-cart']"));
		act.moveToElement(addToCart).click().build().perform();
		Thread.sleep(3000);
    //	Alert alertpop=driver.switchTo().alert();
	//	String alertTextMessage=alertpop.getText();
	//	System.out.println(alertTextMessage);
		driver.switchTo().parentFrame();	
		WebElement CartItems=driver.findElement(By.xpath("//h3[@class='heading']//span[@class='tb_items']"));
		act.moveToElement(CartItems).build().perform();
 	}
}
