package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM {
	
	private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement adminUser; 
	
	@FindBy(id="input-password")
	private WebElement emailPassword; 
	
	@FindBy(id="input-password")
	private WebElement adminPassword; 
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement adminLoginBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement alertMessage;
	
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

	public String alertMessageAdminLogin() {
		return this.alertMessage.getText();
	}
	
}
