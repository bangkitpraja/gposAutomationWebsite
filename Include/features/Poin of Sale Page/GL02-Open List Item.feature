Feature: Open List Item Popup Menu
  As a user, I able to open List Item Menu
  
  Background:
  	Given I already logged in to the system
  	When I navigate to the Point of Sale Menu

  Scenario: Open List Item Menu
    And I clicking the Search Item button
    Then the List Item popup should be displayed