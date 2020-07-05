package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM {
	
	private WebDriver driver; 
	
	public AddCategoryPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[@data-original-title='Add New']")
	private WebElement addCategoryLink;
	
	@FindBy(id="input-name1")
	private WebElement newCategoryName; 
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement newCategoryDescription;
	
	@FindBy(id="input-meta-title1")
	private WebElement newMetaTagTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement newMetaTagDescription;
	
	@FindBy(xpath="//button[@data-original-title='Save']")
	private WebElement SaveBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertMessage;
	
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
	
	public void sendNewCategoryDescription(String newCategoryDescription) {
		this.newCategoryDescription.clear();
		this.newCategoryDescription.sendKeys(newCategoryDescription);
	}
	
	public void sendNewCategoryName(String newCategoryName) {
		this.newCategoryName.clear();
		this.newCategoryName.sendKeys(newCategoryName);
	}
	
	public void moveToAddCategoryLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(addCategoryLink).click().build().perform();
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
