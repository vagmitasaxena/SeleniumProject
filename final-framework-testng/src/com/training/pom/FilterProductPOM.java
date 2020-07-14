package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterProductPOM {
	
	private WebDriver driver; 
	
	public FilterProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement adminUser; 
	
	@FindBy(id="input-password")
	private WebElement adminPassword; 
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement adminLoginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catelogMenu;
	
	@FindBy(xpath="//li[@id='menu-catalog']//a[contains(text(),'Products')]")
	private WebElement productLink;
	
	@FindBy(id="input-name")
	private WebElement productName; 
	
	@FindBy(id="input-price")
	private WebElement price; 
	
	@FindBy(id="input-model")
	private WebElement model; 
	
	@FindBy(id="button-filter")
	private WebElement filterButton;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id="input-status")
	private WebElement status;
	
	@FindBy(id="input-image")
	private WebElement image;
	
	public void clickStatus() {
		this.status.click(); 
	}
	
	public void clickImage() {
		this.image.click(); 
	}
	
	public void selectImage(String text) {
		Select sel=new Select(image); 
		sel.selectByVisibleText(text);
	}
	
	public void selectStatus(String text) {
		Select sel=new Select(status); 
		sel.selectByVisibleText(text);
	}
	
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	public void clickFilterBtn() {
		this.filterButton.click(); 
	}
	
	public void sendModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}

	public void moveToProductLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(productLink).click().build().perform();
	}
	
	public void moveToCatelogMenuLink() {
		Actions act=new Actions(driver);
		act.moveToElement(catelogMenu).build().perform();
	}
	
	public void sendAdminUsername(String adminUser) {
		this.adminUser.clear();
		this.adminUser.sendKeys(adminUser);
	}
	
	public void sendAdminPassword(String adminPassword) {
		this.adminPassword.clear();
		this.adminPassword.sendKeys(adminPassword);
	}
	
	public void clickAdminLoginBtn() {
		this.adminLoginBtn.click(); 
	}

}
