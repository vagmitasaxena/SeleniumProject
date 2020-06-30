package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordValidationPOM {
	private WebDriver driver; 
	
	public PasswordValidationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
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

	public void moveToLoginLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(loginLink).click().build().perform();
	}
	
	public void moveToAccountLink() {
		Actions act=new Actions(driver);
		act.moveToElement(accountLink).build().perform();
	}
}
