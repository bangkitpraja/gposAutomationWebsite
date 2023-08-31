Feature: Poin of Sale (POS) UI
  As a User I want to be able to access poin of sale (POS) UI menu


  Scenario: Verify user able to go to Point Of Sale (POS) menu
 		Given I already logged in to the system
    When I close the popup image
    And I open the poin of sale menu
    Then The Point Of Sale dashboard is open