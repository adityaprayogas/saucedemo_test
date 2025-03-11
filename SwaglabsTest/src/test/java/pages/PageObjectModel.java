package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
	
	@FindBy(id = "user-name")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;

	@FindBy(name = "login-button")
	public WebElement loginButton;
	
	@FindBy(className = "inventory_list")
	public WebElement inventoryTitle;
	
	@FindBy(className = "inventory_list")
	public WebElement productList;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	public WebElement addToCartButton;
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement addedToCartButton;
	
	@FindBy(className = "shopping_cart_badge")
	public WebElement cartIcon;
	
	@FindBy(className = "shopping_cart_link")
	public WebElement cartIcons;
	
	@FindBy(className = "cart_list")
	public WebElement cartTitle;
	
	@FindBy(className = "product_sort_container")
	public WebElement filterDropdown;
	
	@FindBy(xpath = "//option[@value='lohi']")
	public WebElement filterOptionLow;
	
	@FindBy(xpath = "//option[@value='za']")
	public WebElement filterOptionName;
	
	@FindBy(xpath = "//option[@value='hilo']")
	public WebElement filterOptionHigh;
	
	@FindBy(id = "login-button")
	public WebElement loginForm;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	public WebElement addtoCartButton;
	
	public PageObjectModel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
