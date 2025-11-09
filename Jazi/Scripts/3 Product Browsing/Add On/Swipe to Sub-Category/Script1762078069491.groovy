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
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys as Keys

String btn = CustomKeywords.'jazi.Jazi.swipeUpToText'('LESS THAN SAR 99')


if(Mobile.waitForElementPresent(findTestObject(btn), 10, FailureHandling.STOP_ON_FAILURE)) {
	
	// Scroll up until specific text
	CustomKeywords.'jazi.Jazi.swipeUpToText'('LESS THAN SAR 99')
	KeywordUtil.markPassed('-------------Sub Category Found---------------------')
	
	
}else{
	
	KeywordUtil.logInfo("Sub Category not found..............:")
	
}


	
	
	
	


// Scroll down until specific text
//CustomKeywords.'jazi.Jazi.swipeUpToText'('TOPS')