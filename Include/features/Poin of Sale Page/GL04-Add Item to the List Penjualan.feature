Feature: Add Item to the List Penjualan
  As a User I want to add item to the list penjualan

  Background: 
    Given I already logged in to the system
    When I navigate to the Point of Sale Menu

  Scenario Outline: Verify user able to add item to list Penjualan Produk
    When I Search Item in List "<SpecificItem>" Item
    And I add item on popup List Item
    Then Verify Item results is displayed correctly

    Examples: 
      | SpecificItem |
      | amox         |
