Feature: Finding New Cars
  As a user I want to find new cars in Car Dekho Website

  Background: 
    Given user navigate to the website

  Scenario Outline: User finding a new car
    When user choose menu as new cars
    Then user clicks on find new cars
    And user search for <brand> car
    And user validate car titile <brand>
    

    Examples: 
      | brand |
      | Kia   |
      | Honda |
      | MG    |
      | Tata  |
