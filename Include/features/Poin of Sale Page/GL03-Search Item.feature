Feature: Search Item
  As a user, I aim to search for an item within the system

  Background: 
    Given I already logged in to the system
    When I navigate to the Point of Sale Menu

  Scenario Outline: Search Item using Name Item
    When the List Item popup is displayed
    And I enter Name Item "<NameItem>" to the search column
    Then Verify the Item results are displayed correctly

    Examples: 
      | NameItem |
      | amox     |

  Scenario Outline: Search Item using Specific Item
    When the List Item popup is displayed
    And I enter Item "<SpecificItem>" to the search column
    Then Verify the Item results are displayed correctly

    Examples: 
      | SpecificItem |
      | amox         |
      |        10521 |
      |        10521 |
