package com.gpostlite.website

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import internal.GlobalVariable

public class LoginPage {
	def validation = new Validation()

	@Keyword
	def validateLoginPageElementPresent() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		element.add(findTestObject('Page Masuk - GPOS Lite/glEmail'))
		element.add(findTestObject('Page Masuk - GPOS Lite/glPassword'))
		element.add(findTestObject('Page Masuk - GPOS Lite/glBtn_masuk'))
		validation.validateElementPresent(element)
	}

	@Keyword
	def validateDashboardPageElementPresent() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		element.add(findTestObject('Page_Dasbor - GPOS Lite/glPopupImage'))
		element.add(findTestObject('Page_Dasbor - GPOS Lite/glDashboardTitle'))
		validation.validateElementPresent(element)
	}

	@Keyword
	def validateInvalidCredentials() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		ArrayList<String> expected_text = new ArrayList<String>();
		element.add(findTestObject('Page Masuk - GPOS Lite/glAlerts'))
		expected_text.add('Tidak dapat memverifikasi user')
		validation.validateElementText(element,expected_text)
	}
}
