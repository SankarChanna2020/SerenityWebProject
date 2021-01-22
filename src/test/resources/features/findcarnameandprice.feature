Feature: Finding  Cars Names and Prices
  As a user I want to find new cars Names and Price in Car Dekho Website

  Background: 
    Given user navigate to the website

  Scenario Outline: User finding a new cars name and Price
    When user choose menu as new cars
    Then user clicks on find new cars
    And user search for <brand> car
    And user find car name and price
    And user update car name and price in file for each brand <brand>

    Examples: 
      | brand |
      | Kia   |
      | Honda |
      | MG    |
      | Tata  |
