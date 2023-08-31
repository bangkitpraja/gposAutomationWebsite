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
import com.gpostlite.website.BrowserUtility



class AddItemPenjualanList {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When('I Search Item in List "(.*)" Item')
	def I_Search_Item_in_List_Item(String SpecificItem) {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/Popup List Item/Open List Item Popup'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/Popup List Item/The Popup List Item is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/List Item/Search Specific Item on the List Item'), [('SpecificItem') : SpecificItem], FailureHandling.STOP_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/List Item/Search Item Successfully Displayed'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@And('I add item on popup List Item')
	def I_add_item_on_popup_List_Item() {
		WebUI.callTestCase(findTestCase('Web UI Test/Pages/Poin of Sale Page/List Item/Add Item to the List Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@Then('Verify Item results is displayed correctly')
	def VerifyItemisCorrect() {
		String SelectedItem = WebUI.getAttribute(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glResultSelectedItem'), 'value')
		KeywordUtil.logInfo("Item yang kamu pilih : " + SelectedItem)
		WebUI.verifyElementVisible(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glResultSelectedItem'), FailureHandling.STOP_ON_FAILURE)

		new BrowserUtility().clickButton(findTestObject('Page_Point Of Sales - GPOS Lite/glAddItemBtn'), FailureHandling.STOP_ON_FAILURE,'Success click Add Item List')
		WebUI.verifyElementVisible(findTestObject('Page_Point Of Sales - GPOS Lite/glListItemPenjualan'), FailureHandling.STOP_ON_FAILURE)

		String ItemName = WebUI.getText(findTestObject('Page_Point Of Sales - GPOS Lite/glItemSelected', [('SelectedItem') : SelectedItem]))
		String newItemName = ItemName.replaceAll("\\bNR\\b\\s*", "");
		KeywordUtil.logInfo("Item pada List Penjualan : " + newItemName)

		if (SelectedItem == newItemName) {
			KeywordUtil.logInfo("Item sudah sesuai")
		} else {
			KeywordUtil.logInfo("Item tidak sesuai")
		}
		
		//take capture
		WebUI.takeFullPageScreenshot()

		WebUI.closeBrowser()

	}
}