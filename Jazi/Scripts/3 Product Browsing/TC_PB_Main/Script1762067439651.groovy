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

Mobile.startExistingApplication("com.jazi.app.stage", FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/Scroll Up Down check'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/Check Parent Category on Dashboard'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/Swipe to Sub-Category'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/Product Category Seletion'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/select product from the list'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/Product add to wishlist'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/go back to product listing screen'),
	null,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/3 Product Browsing/Add On/search product by search bar'),
	null,FailureHandling.STOP_ON_FAILURE)	