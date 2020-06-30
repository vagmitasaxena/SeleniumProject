package RetailProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.SearchProductsDisplayPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SearchProductsDisplay {
	private WebDriver driver;
	private String baseUrl;
	private SearchProductsDisplayPOM searchProductsDisplayPOM;
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
		searchProductsDisplayPOM = new SearchProductsDisplayPOM(driver); 
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
    //    WebElement shopLink=driver.findElement(By.id("menu_all_categories_Menu_VIfWm2LT_VLHXC"));
	//	Actions act=new Actions(driver);
	//	act.moveToElement(shopLink).build().perform();
	//	WebElement ethnicLink=driver.findElement(By.xpath("//li[@class='tb_menu_category_VLHXC tb_link']"));
	//	act.moveToElement(ethnicLink).click().build().perform();
		searchProductsDisplayPOM.moveToShopLink();
		Thread.sleep(3000);
		searchProductsDisplayPOM.moveToEthnicLinkClick();
//		driver.findElement(By.xpath("//div[@class='sort']//select")).click();
//      WebElement SortBy=driver.findElement(By.xpath("//div[@class='sort']//select"));
		searchProductsDisplayPOM.clickSortLink();
		WebElement SortBy=searchProductsDisplayPOM.SortLink();
		String dropdownvalues=SortBy.getText();
		System.out.println(dropdownvalues);
		Select SortList=new Select(SortBy);
        SortList.selectByVisibleText("Name (A - Z)");
        String selected=SortList.getFirstSelectedOption().getText();
        String expected="Name (A - Z)";
        System.out.println(selected);
        Assert.assertEquals(selected,expected);
        Thread.sleep(8000); 
//        driver.findElement(By.xpath("//div[@class='sort']//select")).click();
        searchProductsDisplayPOM.clickSortLink();
		driver.navigate().refresh();
		Select sel = new Select(SortBy);
		sel.selectByVisibleText("Rating (Highest)");
		selected=SortList.getFirstSelectedOption().getText();
		expected="Rating (Highest)";
        System.out.println(selected);
        Assert.assertEquals(selected,expected);
        Thread.sleep(3000);
	}
}
