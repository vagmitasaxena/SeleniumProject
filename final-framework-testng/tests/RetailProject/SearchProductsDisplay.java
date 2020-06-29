package RetailProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SearchProductsDisplay {
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
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void SortingTest() throws InterruptedException {
        WebElement shopLink=driver.findElement(By.id("menu_all_categories_Menu_VIfWm2LT_VLHXC"));
		Actions act=new Actions(driver);
		act.moveToElement(shopLink).build().perform();
		Thread.sleep(3000);
		WebElement ethnicLink=driver.findElement(By.xpath("//li[@class='tb_menu_category_VLHXC tb_link']"));
		act.moveToElement(ethnicLink).click().build().perform();
		driver.findElement(By.xpath("//div[@class='sort']//select")).click();
        WebElement SortBy=driver.findElement(By.xpath("//div[@class='sort']//select"));
		String dropdownvalues=SortBy.getText();
		System.out.println(dropdownvalues);
		Select SortList=new Select(SortBy);
        SortList.selectByVisibleText("Name (A - Z)");
        Thread.sleep(8000); 
        driver.findElement(By.xpath("//div[@class='sort']//select")).click();
		driver.navigate().refresh();
		Select sel = new Select(driver.findElement(By.xpath("//div[@class='sort']//select")));
		sel.selectByVisibleText("Rating (Highest)");
        Thread.sleep(3000);
	}
}
