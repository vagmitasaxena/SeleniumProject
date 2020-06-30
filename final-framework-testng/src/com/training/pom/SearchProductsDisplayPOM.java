package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductsDisplayPOM {
	private WebDriver driver; 
	
	public SearchProductsDisplayPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='tb_menu_category_VLHXC tb_link']")
	private WebElement ethnicLink;
	
	@FindBy(xpath="//div[@class='sort']//select")
	private WebElement sortLink;
	
	@FindBy(id="menu_all_categories_Menu_VIfWm2LT_VLHXC")
	private WebElement shopLink; 
	
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

}
