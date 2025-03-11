Feature: Inventory Page of Saucedemo

  # Positive Test Cases

  Scenario: User successfully logs in and views the inventory page
  	Given the user navigate to Login page
    When the user logs in with valid credentials
    Then the user should be redirected to the inventory page
    And the inventory page should display a list of products

  Scenario: User views the product name and price
    Given the user navigate to Login page
    When the user logs in with valid credentials
    Then the user should see the product name for each item
    And the user should see the price for each item

  Scenario: User adds a product to the cart
    Given the user navigate to Login page
    When the user logs in with valid credentials
    When the user clicks on the "Add to Cart" button for a product
    Then the product should be added to the cart
    And the cart icon should reflect the updated item count

  Scenario: User navigates to the cart page
    Given the user navigate to Login page
    When the user logs in with valid credentials
    When the user clicks on the cart icon
    Then the user should be redirected to the cart page

  Scenario: User filters products by price (low to high)
    Given the user navigate to Login page
    When the user logs in with valid credentials
    When the user selects the "Price (low to high)" filter from the dropdown
    Then the products should be displayed in ascending order of price

# Negative Test Cases

  Scenario: User cannot access the inventory page without logging in
    Given the user access the inventory page directly
    Then the user should be redirected to the login page
  
  Scenario: User cannot add products to the cart
  	Given the user is logged in with valid credentials
  	When the user tries to add a product to the cart
  	Then the user should not be able to add the product to the cart
  	And the cart icon should not reflect any change in item count
  
  Scenario: User cannot filter products by name (Z to A)
  	Given the user is logged in with valid credentials
  	When the user selects the "Name (Z to A)" filter from dropdown
  	Then the products list should not change by name
  	And the products should not be displayed in descending order of name
  	
  Scenario: User cannot filter products by price (low to high)
  	Given the user is logged in with valid credentials
  	When the user select the "Price (high to low)" filter from dropdown
  	Then the products list should not change by price 
  	And the products should not be displayed in ascending order of price
  	
 	Scenario: User cannot remove items that have been added to the cart
 		Given the user is logged in with valid credentials
 		When the user click on the "Add to Cart" button for a product
 		When the user click on the "Remove" button a product
 		Then the product cannot be removed
