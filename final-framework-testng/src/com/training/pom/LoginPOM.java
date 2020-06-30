package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(id="input-email")
	private WebElement emailId; 
	
	@FindBy(id="input-password")
	private WebElement emailPassword; 
	
	@FindBy(id="input-confirm")
	private WebElement emailConfirmPassword; 
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement emailLoginBtn; 
	
	@FindBy(xpath="//li[@class='tb_link dropdown tb_menu_system_account_account']")
	private WebElement accountLink;
	
	@FindBy(xpath="//li[@class='tb_link tb_menu_system_account_login']")
	private WebElement loginLink;
	
	@FindBy(id="menu_all_categories_Menu_VIfWm2LT_VLHXC")
	private WebElement shopLink; 
	
	@FindBy(xpath="//li[@class='tb_menu_category_VLHXC tb_link']")
	private WebElement ethnicLink;
	
	@FindBy(xpath="//div[@class='sort']//select")
	private WebElement sortLink;
	
	@FindBy(xpath="//a[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement itemLink;
	
	@FindBy(xpath="//div[@id='ProductsSystem_QQI8r357']/div[1]/div[2]/div/div[2]/div[2]/a/span")
	private WebElement selectedItemLink;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement cartItems;
	
	public void moveToCartItemsLink() {
		Actions act=new Actions(driver);
		act.moveToElement(cartItems).build().perform();
	}
	
	public void moveToAddToCartLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(addToCart).click().build().perform();
	}
	
	public void moveToSelectedItemLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(selectedItemLink).click().build().perform();
	}
	
	public void moveToItemLink() {
		Actions act=new Actions(driver);
		act.moveToElement(itemLink).build().perform();
	}
	
	public void clickSortLink() {
		this.sortLink.click(); 
	}
	
	public WebElement SortLink() {
		return this.sortLink; 
	}
	
	public void moveToEthnicLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(ethnicLink).click().build().perform();
	}
	
	public void moveToShopLink() {
		Actions act=new Actions(driver);
		act.moveToElement(shopLink).build().perform();
	}
	
	public void moveToLoginLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(loginLink).click().build().perform();
	}
	
	public void moveToAccountLink() {
		Actions act=new Actions(driver);
		act.moveToElement(accountLink).build().perform();
	}
	
	public void sendUserEmail(String emailId) {
		this.emailId.clear();
		this.emailId.sendKeys(emailId);
	}
	
	public void sendUserEmailPassword(String emailPassword) {
		this.emailPassword.clear();
		this.emailPassword.sendKeys(emailPassword);
	}
	
	public void sendUserEmailConfirmPassword(String emailConfirmPassword) {
		this.emailConfirmPassword.clear();
		this.emailConfirmPassword.sendKeys(emailConfirmPassword);
	}
	
	public void clickEmailLoginBtn() {
		this.emailLoginBtn.click(); 
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
