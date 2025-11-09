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

Mobile.startExistingApplication("com.jazi.app.stage", FailureHandling.STOP_ON_FAILURE)

if(Mobile.waitForElementPresent(btn_eng, 10)) {
	
	Mobile.callTestCase(findTestCase('Test Cases/1 Splash/Add Ons Splash Screen/Select_language'),
		null,FailureHandling.STOP_ON_FAILURE)
	
	Mobile.callTestCase(findTestCase('Test Cases/1 Splash/Add Ons Splash Screen/btn_Continue'),
		null,FailureHandling.STOP_ON_FAILURE)
	
	 if (Mobile.waitForElementPresent(btn_sure, 10)) {
		 
		 Mobile.callTestCase(findTestCase('Test Cases/1 Splash/Add Ons Splash Screen/dont_miss_anything'),
			 null,FailureHandling.STOP_ON_FAILURE)
		 
		 Mobile.callTestCase(findTestCase('Test Cases/1 Splash/Add Ons Splash Screen/btn - Allow Permission'),
			 null,FailureHandling.STOP_ON_FAILURE)
		 
	 }else if(Mobile.waitForElementNotPresent(nav_bar, 10, FailureHandling.STOP_ON_FAILURE)){
		 
		 KeywordUtil.logInfo("User Navigate to the Dashboard Successfully...")
		 
	 }
	
}else if(Mobile.waitForElementNotPresent(nav_bar, 10, FailureHandling.STOP_ON_FAILURE)){
	
	KeywordUtil.logInfo("User Navigate to the Dashboard Successfully...")
}


Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()