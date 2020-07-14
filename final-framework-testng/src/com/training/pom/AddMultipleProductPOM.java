package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMultipleProductPOM {
	
	private WebDriver driver; 
	
	public AddMultipleProductPOM(WebDriver driver) {
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
	
	@FindBy(id="input-name1")
	private WebElement productName; 
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle; 
	
	@FindBy(id="input-model")
	private WebElement model; 
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//a[@data-original-title='Add New']")
	private WebElement addNewProduct;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement data;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement links;
	
	@FindBy(id="input-category")
	private WebElement category;
	
	@FindBy(xpath="//button[@data-original-title='Save']")
	private WebElement SaveBtn; 
	
	@FindBy(xpath="//div[contains(text(),' Warning: Please check the form carefully for errors! ')]")
	private WebElement errorMessage;
	
	@FindBy(xpath="//div[contains(text(),' Success: You have modified products!')]")
	private WebElement successMessage;
	
	public String successMessageDisplayed() {
		return this.successMessage.getText();
	}
	
	public String errorMessageDisplayed() {
		return this.errorMessage.getText();
	}
	
	public void clickSaveBtn() {
		this.SaveBtn.click(); 
	}
	
	public void sendCategory(String category) {
		this.category.clear();
		this.category.sendKeys(category);
	}
	
	public void clickLinksTab() {
		this.links.click(); 
	}
	
	public void clickDataTab() {
		this.data.click(); 
	}
	
	public void clickAddNewProduct() {
		this.addNewProduct.click(); 
	}
	
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void sendModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	public void sendMetaTagTitle(String metaTagTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
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
