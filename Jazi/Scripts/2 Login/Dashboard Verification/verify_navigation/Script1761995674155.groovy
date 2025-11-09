
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String btn = 'Object Repository/Dasboard/search bar'
Mobile.waitForElementPresent(findTestObject(btn), 15)
KeywordUtil.logInfo("Search bar Found on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn1 = 'Object Repository/Dasboard/btn - Wishlist'
Mobile.waitForElementPresent(findTestObject(btn1), 15)
KeywordUtil.logInfo("Wishlist Found on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn2 = 'Object Repository/Dasboard/tab - Kids Parent Category'
Mobile.waitForElementPresent(findTestObject(btn2), 15)
Mobile.tap(findTestObject(btn2), 3)
KeywordUtil.logInfo("Kids Parent Category Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn3 = 'Object Repository/Dasboard/tab - Women Parent Category'
Mobile.waitForElementPresent(findTestObject(btn3), 15)
Mobile.tap(findTestObject(btn3), 3)
KeywordUtil.logInfo("Women Parent CategoryTab Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn4 = 'Object Repository/Dasboard/tab - Men Parent Category'
Mobile.waitForElementPresent(findTestObject(btn4), 15)
Mobile.tap(findTestObject(btn4), 3)
KeywordUtil.logInfo("Men Parent Category Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn5 = 'Object Repository/Dasboard/btn - Cart tab'
Mobile.waitForElementPresent(findTestObject(btn5), 15)
Mobile.tap(findTestObject(btn5), 3)
KeywordUtil.logInfo("Cart Tab Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn6 = 'Object Repository/Dasboard/btn - Search tab'
Mobile.waitForElementPresent(findTestObject(btn6), 15)
Mobile.tap(findTestObject(btn6), 3)
KeywordUtil.logInfo("Search Tab Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn7 = 'Object Repository/Dasboard/btn - Home tab'
Mobile.waitForElementPresent(findTestObject(btn7), 15)
Mobile.tap(findTestObject(btn7), 3)
KeywordUtil.logInfo("Home Tab Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

String btn8 = 'Object Repository/Dasboard/btn - Referrals tab'
Mobile.waitForElementPresent(findTestObject(btn8), 15)
Mobile.tap(findTestObject(btn8), 3)
KeywordUtil.logInfo("Referral Tab Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")

Mobile.pressBack()
Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
Mobile.pressBack()
Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

String btn9 = 'Object Repository/Dasboard/btn - Profile tab'
Mobile.waitForElementPresent(findTestObject(btn9), 15)
Mobile.tap(findTestObject(btn9), 15)
KeywordUtil.logInfo("Profile Tab Found and navigate on Dashboard....")
KeywordUtil.logInfo("----------------------------------")










