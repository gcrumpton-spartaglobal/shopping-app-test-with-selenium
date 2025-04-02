Feature: Opening and adding items to my cart

  In order to potentially buy an item
  As a user of the shopping app website
  I want to be able to click on the shopping cart button,
  and also

  Scenario: Click on cart with no items
    Given I am on the home page
    When I click the cart button
    Then The cart menu is opened
