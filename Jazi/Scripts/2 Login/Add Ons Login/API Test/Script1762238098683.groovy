import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper
import jazi.Jazi


import org.openqa.selenium.Keys as Keys

Mobile.startExistingApplication("com.jazi.app.stage", FailureHandling.STOP_ON_FAILURE)


String btn = 'Object Repository/Dasboard/btn - Profile tab'
Mobile.waitForElementPresent(findTestObject(btn), 5)
Mobile.tap(findTestObject(btn), 3)
KeywordUtil.logInfo("User tap on the Login Button....")
KeywordUtil.logInfo("--------------------------------")


//// ✅ Define phone number variable (you can replace with GlobalVariable if needed)
//def countryCode = '+966'
//def phone = '599642820'  // 🔁 You can change this or pass it from Test Suite variable
//
//// 1️⃣ Call API and get OTP using Custom Keyword
//def otpCode = CustomKeywords.'jazi.Jazi.getOtp'(countryCode, phone)
//
//// 2️⃣ Continue mobile test only if OTP received
//if (otpCode != null) {
//	println("🔢 Using OTP: ${otpCode}")
//
	String btn1 = 'Object Repository/Login/btn - LOGIN OR SIGNUP'
	Mobile.waitForElementPresent(findTestObject(btn1), 5)
	Mobile.tap(findTestObject(btn1), 3)
	KeywordUtil.logInfo("User tap on the Login Button....")
	KeywordUtil.logInfo("--------------------------------")
//
//	// Enter phone number
//	Mobile.setText(findTestObject('Object Repository/LoginScreen/PhoneField'), phone, 5)
//	Mobile.tap(findTestObject('Object Repository/LoginScreen/GetOtpButton'), 5)
//
//	// Enter OTP
//	Mobile.setText(findTestObject('Object Repository/LoginScreen/OtpField'), otpCode, 5)
//	Mobile.tap(findTestObject('Object Repository/LoginScreen/SubmitButton'), 5)
//
//	println("✅ Login successful using OTP.")
//} else {
//	println("⚠️ OTP not retrieved. Please check API or phone number.")
//}
//
//

	// Set your variables
	String code = '+966'
	String phone = '599642820'
	
	Mobile.setText(findTestObject('Object Repository/Login/phone number field'), phone, 5)
	Mobile.tap(findTestObject('Object Repository/Login/btn - NEXT'), 5)
	
	// Call the API keyword
	String otpCode = CustomKeywords.'jazi.Jazi.getOtp'(code, phone)
	println("New OTP Received....:" otpCode)
	
	if (otpCode != null) {
		println("Using OTP....: ${otpCode}")

//		Mobile.setText(findTestObject('Object Repository/Login/OTP - 1'), otpCode, 5)
//		Mobile.tap(findTestObject('Object Repository/Login/btn - VERIFY'), 5)

	} else {
		println("Failed to retrieve OTP. Stopping test.")
		assert false
	}
	
	

