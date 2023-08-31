# GPOS Automation Website
______

## Getting Started
These instructions will get you a copy of the project up and running on your local machine.

### Important Notes:
- **This project is part of Technical Test QA Engineer.**
- Using katalon-bdd-cucumber to express Test Cases (or Test Scenarios) in Cucumber format using Gherkin language.

### Prerequisites
- [Katalon Studio](https://www.katalon.com/) - [Installation and Setup](https://docs.katalon.com/x/HwAM)
- Internet access

### Setting Up
- [Check out](https://git-scm.com/book/en/v2/Git-Basics-Getting-a-Git-Repository) the code from this repository
- [Open the project](https://docs.katalon.com//display/KD/Manage+Test+Project) from Katalon Studio

### Executing a Feature
![Execute a Feature file](https://github.com/bangkitpraja/gposAutomationWebsite/blob/main/Tutorials/Figures/Execute%20a%20feature%20files.png)
1. Expand the **Include** inside Tests Explorer, where all the features and step definition scripts located
2. Select the **Feature** you want to execute
3. Execute the **Feature** by click Run button or using shortcut key CTRL + SHIFT + A

### Executing a Test Suite
![Execute a Test Suite](https://github.com/bangkitpraja/gposAutomationWebsite/blob/main/Tutorials/Figures/Execute%20a%20multiple%20test%20case%20in%20test%20suite.png)
1. Expand the **Test Suites** folder insite Tests Explorer
2. Select the Test Suites **RunAllScenario** to run all scenario or select a single test suites
3. Execute the **Test Suites** by click Run button or using shortcut key CTRL + SHIFT + A

### Report
To generate report make sure you already install [**Basic Report**](https://store.katalon.com/product/59/Basic-Report) plugin

## Test Features
Below is sample gherkin language that used for the Test Cases
### Story: As a user I want to login to GPOS Lite
```Gherkin
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
      | username   | password                   |
      | testingpkp | NEAmZBfdbNY=               |
      | testingpk  | UfmyG5/V5OKzGc5Adn3a6Q==   |
```
