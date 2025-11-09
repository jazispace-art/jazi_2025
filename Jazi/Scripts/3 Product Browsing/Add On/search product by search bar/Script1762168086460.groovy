import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword as MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys


String text = 'Stylish Swim Shots'

if (Mobile.waitForElementNotPresent(findTestObject('Object Repository/Common Objects/Search bar'), 30)) {
	
    Mobile.tap(findTestObject('Object Repository/Common Objects/Search bar'), 30)
	
	
	if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/searchbar - Search Here'), 10)) {
		
		Mobile.setText(findTestObject('Object Repository/Common Objects/searchbar - Search Here'), text, 10)
	
		Mobile.sendKeys(null, Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
	} else {
		KeywordUtil.logInfo('Search bar not found')
	}
	
    KeywordUtil.logInfo('Search bar opened')
} else {
    KeywordUtil.logInfo('Search bar not found')
}

