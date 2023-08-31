package com.gposlite.pos
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



class SearchItemList {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@When('the List Item popup is displayed')
	def the_list_Item_popup_is_displayed() {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/Popup List Item/Open List Item Popup'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/Popup List Item/The Popup List Item is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@And('I enter Name Item "(.*)" to the search column')
	def I_enter_Name_Item_to_the_search_column(String NameItem) {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/List Item/Search Item on the List Item'), [('NameItem') : NameItem], FailureHandling.STOP_ON_FAILURE)
	}
	
	@And('I enter Item "(.*)" to the search column')
	def I_enter_Specific_Item_to_the_search_column(String SpecificItem) {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/List Item/Search Specific Item on the List Item'), [('SpecificItem') : SpecificItem], FailureHandling.STOP_ON_FAILURE)
	}

	@Then('Verify the Item results are displayed correctly')
	def Verify_the_Item_results_are_displayed_correctly() {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/List Item/Search Item Successfully Displayed'), [:], FailureHandling.STOP_ON_FAILURE)
		//take capture
		WebUI.takeFullPageScreenshot()

		WebUI.closeBrowser()
	}
}