package com.gposlite.login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.gpostlite.website.BrowserUtility
import com.gpostlite.website.LoginPage


class loginSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given('GPOS homepage is displayed')
	def GPOS_homepage_is_displayed() {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/The Login Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.takeFullPageScreenshot()
	}

	@When('I login with valid "(.*)" username and "(.*)" password')
	def I_login_the_system_with_valid_username_password(String username, String password) {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/Login with valid username and password'), [('username') : username
			, ('password') : password], FailureHandling.STOP_ON_FAILURE)
	}

	@Then('The Dashboard Page is loaded successfully')
	def The_Dashboard_Page_is_loaded_successfully() {

		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Dashboard Page/The Dashboard Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)

		//take capture
		WebUI.takeFullPageScreenshot()

		WebUI.closeBrowser()
	}

	@Given('I already logged in to the system')
	def I_already_logged_in_to_the_system () {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/The Login Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/Login with valid username and password'), [('username') : GlobalVariable.username
			, ('password') : GlobalVariable.encryptedPassword], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Dashboard Page/The Dashboard Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@When('I login with invalid "(.*)" username and "(.*)" password')
	def I_login_the_system_with_invalid_username_password(String username, String password) {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/Login with invalid username and password'), [('username') : username
			, ('password') : password], FailureHandling.STOP_ON_FAILURE)
	}

	@Then('I should NOT be able to login')
	def I_should_NOT_be_able_to_login() {

		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/Login with invalid username and password'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/Verify error message for login'),[:], FailureHandling.STOP_ON_FAILURE)

		//take capture
		WebUI.takeFullPageScreenshot()

		WebUI.closeBrowser()
	}
}