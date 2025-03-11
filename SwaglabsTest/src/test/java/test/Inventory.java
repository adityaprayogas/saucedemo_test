package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.PageObjectModel;

public class Inventory {

	@Before()
	public void beforeTest() {
		driver.manage().window().maximize();
	}

	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://www.saucedemo.com/";
	PageObjectModel BaseObject = new PageObjectModel(driver);

	@Given("the user navigate to Login page")
	public void the_user_navigate_to_login_page() {

		driver.get(baseUrl);
	}

	@When("the user logs in with valid credentials")
	public void the_user_logs_in_with_valid_credentials() {

		PageObjectModel BaseObject = new PageObjectModel(driver);
		BaseObject.username.sendKeys("standard_user");
		BaseObject.password.sendKeys("secret_sauce");
		BaseObject.loginButton.click();

	}

	@Then("the user should be redirected to the inventory page")
	public void the_user_should_be_redirected_to_the_inventory_page() {

		Assert.assertTrue(BaseObject.productList.isDisplayed());
	}

	@Then("the inventory page should display a list of products")
	public void the_inventory_page_should_display_a_list_of_products() {
		
		Assert.assertTrue(BaseObject.productList.isDisplayed());
		Assert.assertTrue(BaseObject.productList.findElements(By.className("inventory_item")).size() > 0);
	}

	@Then("the user should see the product name for each item")
	public void the_user_should_see_the_product_name_for_each_item() {

		Assert.assertTrue(BaseObject.productList.isDisplayed());
		for (WebElement product : BaseObject.productList.findElements(By.className("inventory_item_name"))) {
			Assert.assertTrue(product.isDisplayed());
		}
	}

	@Then("the user should see the price for each item")
	public void the_user_should_see_the_price_for_each_item() {
		
		Assert.assertTrue(BaseObject.productList.isDisplayed());
		for (WebElement price : BaseObject.productList.findElements(By.className("inventory_item_price"))) {
			Assert.assertTrue(price.isDisplayed());
		}
	}
	
	@When("the user clicks on the {string} button for a product")
	public void the_user_clicks_on_the_button_for_a_product(String AddtoCart) {

		BaseObject.addToCartButton.click();
	}

	@Then("the product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
		
		Assert.assertTrue(BaseObject.addedToCartButton.isDisplayed());
	}

	@Then("the cart icon should reflect the updated item count")
	public void the_cart_icon_should_reflect_the_updated_item_count() {
		
		Assert.assertTrue(BaseObject.cartIcon.isDisplayed());
		Assert.assertEquals("1", BaseObject.cartIcon.getText());
	}

	@When("the user clicks on the cart icon")
	public void the_user_clicks_on_the_cart_icon() {
		
		BaseObject.cartIcons.click();
	}

	@Then("the user should be redirected to the cart page")
	public void the_user_should_be_redirected_to_the_cart_page() {
		
		Assert.assertTrue(BaseObject.cartTitle.isDisplayed());
	}

	@When("the user selects the {string} filter from the dropdown")
	public void the_user_selects_the_filter_from_the_dropdown(String lowtohigh) {
		
		BaseObject.filterDropdown.click();
		BaseObject.filterOptionLow.click();
	}

	@Then("the products should be displayed in ascending order of price")
	public void the_products_should_be_displayed_in_ascending_order_of_price() {
		
		List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));

		double previousPrice = 0.0;
		for (WebElement priceElement : productPrices) {
			double currentPrice = Double.parseDouble(priceElement.getText().replace("$", ""));
			Assert.assertTrue(currentPrice >= previousPrice);
			previousPrice = currentPrice;
		}
	}

	@Given("the user access the inventory page directly")
	public void the_user_access_the_inventory_page_directly() {

		driver.get(baseUrl + "inventory.html");
	}

	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
		
		Assert.assertTrue(BaseObject.loginForm.isDisplayed());
	}

	@Given("the user is logged in with valid credentials")
	public void the_user_is_logged_in_with_valid_credentials() {
		
		driver.get(baseUrl);
		BaseObject.username.sendKeys("problem_user");
		BaseObject.password.sendKeys("secret_sauce");
		BaseObject.loginButton.click();
	}

	@When("the user tries to add a product to the cart")
	public void the_user_tries_to_add_a_product_to_the_cart() {
		
		BaseObject.addtoCartButton.click();
	}

	@Then("the user should not be able to add the product to the cart")
	public void the_user_should_not_be_able_to_add_the_product_to_the_cart() {
		
		String itemCount = BaseObject.cartIcons.getText();
		Assert.assertEquals("", itemCount);
	}

	@Then("the cart icon should not reflect any change in item count")
	public void the_cart_icon_should_not_reflect_any_change_in_item_count() {
		
		Assert.assertEquals("", BaseObject.cartIcons.getText());
	}

	@When("the user selects the {string} filter from dropdown")
	public void the_user_selects_the_select_filter_from_dropdown(String ZtoA) {
		
		BaseObject.filterDropdown.click();
		BaseObject.filterOptionName.click();
	}

	@Then("the products list should not change by name")
	public void the_products_list_should_not_change_by_name() {
		
		Assert.assertTrue(BaseObject.productList.isDisplayed());
	}

	@Then("the products should not be displayed in descending order of name")
	public void the_products_should_not_be_displayed_in_descending_order_of_name() {
		
		Assert.assertTrue(BaseObject.productList.isDisplayed());
		Assert.assertTrue(BaseObject.productList.findElements(By.className("inventory_item")).size() > 0);
	}

	@When("the user select the {string} filter from dropdown")
	public void the_user_select_the_filter_from_dropdown(String hightolow) {

		BaseObject.filterDropdown.click();
		BaseObject.filterOptionHigh.click();
	}

	@Then("the products list should not change by price")
	public void the_products_list_should_not_change_by_price() {
		
		Assert.assertTrue(BaseObject.productList.isDisplayed());
	}

	@Then("the products should not be displayed in ascending order of price")
	public void the_products_should_not_be_displayed_in_ascending_order_of_price() {

		Assert.assertTrue(BaseObject.productList.isDisplayed());
		Assert.assertTrue(BaseObject.productList.findElements(By.className("inventory_item")).size() > 0);
	}

	@When("the user click on the {string} button for a product")
	public void the_user_click_on_the_button_for_a_product(String AddtoCart) {
		
		BaseObject.addToCartButton.click();
	}

	@When("the user click on the {string} button a product")
	public void the_user_click_on_the_button_a_product(String Remove) {
		
		BaseObject.addedToCartButton.click();
	}

	@Then("the product cannot be removed")
	public void the_product_cannot_be_removed() {
		
		Assert.assertTrue(BaseObject.addedToCartButton.isDisplayed());
	}

	@After()
	public void afterTest() {
		driver.quit();
	}

}