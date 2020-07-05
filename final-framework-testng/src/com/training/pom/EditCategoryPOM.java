package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCategoryPOM {
	private WebDriver driver; 
	
	public EditCategoryPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement categoryMenu;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement categoryLink;
	
	@FindBy(id="input-meta-title1")
	private WebElement newMetaTagTitle;
	
	@FindBy(id="input-meta-title1")
	private WebElement newMetaTagDescription;
	
	@FindBy(xpath="//button[@data-original-title='Save']")
	private WebElement SaveBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertMessage;
	
	@FindBy(xpath="//td[contains(text(),'ETHNICORNAMENTS')]//following-sibling::td[2]//a")
	private WebElement editLink;
	
	public void clickEditLink() {
		this.editLink.click(); 
	}
	
	public void selectCategoryToEdit(String Category) {
		String beforeXpath="//td[contains(text(),'";
        String afterXpath="')]//preceding-sibling::td//input";
        String CategoryXpath=beforeXpath+Category+afterXpath;
        driver.findElement(By.xpath(CategoryXpath)).click(); 
	}
	
	public String alertSuccessMessage() {
		return this.alertMessage.getText();
	}
	
	public void clickSaveBtn() {
		this.SaveBtn.click(); 
	}
	
	public void sendNewMetaTagDescription(String newMetaTagDescription) {
		this.newMetaTagDescription.clear();
		this.newMetaTagDescription.sendKeys(newMetaTagDescription);
	}
	
	public void sendNewMetaTagTitle(String newMetaTagTitle) {
		this.newMetaTagTitle.clear();
		this.newMetaTagTitle.sendKeys(newMetaTagTitle);
	}
	
	public void moveToCategoryLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(categoryLink).click().build().perform();
	}
	
	public void moveToCategoryMenuLink() {
		Actions act=new Actions(driver);
		act.moveToElement(categoryMenu).build().perform();
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
