package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductDetailsPOM {
	private WebDriver driver; 
	
	public AddProductDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu_all_categories_Menu_VIfWm2LT_VLHXC")
	private WebElement shopLink; 
	
	@FindBy(xpath="//li[@class='tb_menu_category_VLHXC tb_link']")
	private WebElement ethnicLink;
	
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

	public void moveToEthnicLinkClick() {
		Actions act=new Actions(driver);
		act.moveToElement(ethnicLink).click().build().perform();
	}
	
	public void moveToShopLink() {
		Actions act=new Actions(driver);
		act.moveToElement(shopLink).build().perform();
	}
}
