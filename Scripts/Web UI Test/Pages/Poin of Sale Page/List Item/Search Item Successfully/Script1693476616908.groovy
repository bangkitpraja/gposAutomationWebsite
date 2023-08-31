import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/The Login Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Web UI Test/Pages/Login Page/Login with valid username and password'), [('username') : GlobalVariable.username
	, ('password') : GlobalVariable.encryptedPassword], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Web UI Test/Pages/Dashboard Page/The Dashboard Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Web UI Test/Pages/Dashboard Page/Close the popup image'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Web UI Test/Pages/Dashboard Page/Open the Poin of Sale Page'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Web UI Test/Pages/Dashboard Page/The Poin of Sale Page is Loaded Successfully'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gpostlite.website.BrowserUtility.clickButton'(findTestObject('Page_Point Of Sales - GPOS Lite/glSearchBtn'), FailureHandling.STOP_ON_FAILURE, 'Success to open list item')

WebUI.verifyElementVisible(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glModalListItem'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent('LIST ITEM', false)

WebUI.click(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glInputItem'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glInputItem'), item)
WebUI.delay(3)

String itemResult = WebUI.getText(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glItemResult'))
String newItemResult = itemResult.replaceAll("\nLokasi Rak: -", "")
KeywordUtil.logInfo("Item : " + newItemResult)

WebUI.click(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glBtnSelectedItem', [('item'):newItemResult]), FailureHandling.STOP_ON_FAILURE)

String SelectedItem = WebUI.getAttribute(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glResultSelectedItem'), 'value')

KeywordUtil.logInfo("Item yang kamu pilih : " + SelectedItem)
WebUI.verifyElementVisible(findTestObject('Page_Point Of Sales - GPOS Lite/List Item/glResultSelectedItem'), FailureHandling.STOP_ON_FAILURE)
