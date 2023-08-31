@Login
Feature: Login to Gpos Lite
  As a user I want to login to GPOS Lite

@Valid
  Scenario Outline: Login using valid credential
    Given GPOS homepage is displayed
    When I login with valid "<username>" username and "<password>" password
    Then The Dashboard Page is loaded successfully

    Examples: 
      | username   | password                 |
      | testingpkp | UfmyG5/V5OKzGc5Adn3a6Q== |
      
@Invalid 
  Scenario Outline: Login using invalid credential
    Given GPOS homepage is displayed
    When I login with invalid "<username>" username and "<password>" password
    Then I should NOT be able to login
    
    Examples: 
      | username   | password                 |
      | testingpkp | NEAmZBfdbNY=							|
      | testingpk	 | UfmyG5/V5OKzGc5Adn3a6Q==	|