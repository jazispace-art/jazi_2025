package jazi

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable

public class Jazi {

	@Keyword
	def selectUserSize(String sizeName) {
		try {
			println("👕 Checking for size: ${sizeName}")

			// Dynamic XPath to locate the size element by text
			String xpath = "//*[@text='${sizeName}' or .='${sizeName}']"

			// Create dynamic TestObject
			TestObject sizeOption = new TestObject("dynamicSizeOption")
			sizeOption.addProperty("xpath", ConditionType.EQUALS, xpath)

			// Check if element exists within 5 seconds
			boolean isAvailable = Mobile.verifyElementExist(sizeOption, 5, FailureHandling.OPTIONAL)

			if (isAvailable) {
				Mobile.tap(sizeOption, 5)
				KeywordUtil.logInfo("✅ Size '${sizeName}' is available and selected.")
				println("✅ Size '${sizeName}' is available and selected.")
			} else {
				KeywordUtil.logInfo("⚠️ Size '${sizeName}' is not available.")
				println("⚠️ Size '${sizeName}' is not available.")
			}
		} catch (Exception e) {
			KeywordUtil.markWarning("⚠️ Error while selecting size: ${e.message}")
			e.printStackTrace()
		}
	}

	@Keyword
	def getOtp(String code, String phone) {
		try {
			println("📱 Requesting OTP for: ${code}${phone}")

			// ✅ Load your API request object dynamically
			TestObject request = findTestObject('Object Repository/API Requests/loginWithPhoneOTP', [
				('code'): code,
				('phone'): phone
			])

			// ✅ Send API request
			ResponseObject response = WS.sendRequest(request)
			assert response != null : "No response received from API"

			// ✅ Log and parse
			def responseBody = response.getResponseBodyContent()
			println("API Response: " + responseBody)

			def json = new JsonSlurper().parseText(responseBody)
			def otp = json?.data?.otp

			if (otp) {
				println("OTP received: ${otp}")
				return otp
			} else {
				KeywordUtil.markWarning("OTP not found in response.")
				return null
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Exception in getOtp(): " + e.message)
			return null
		}
	}

	@Keyword
	def subcategorySelection(String categoryName, int maxSwipes = 10) {

		println("🔍 Searching for category: '${categoryName}'")

		int height = Mobile.getDeviceHeight()
		int width = Mobile.getDeviceWidth()
		println("Device Height.....: ${height}, Device Width.....: ${width}")

		int startY = height * 0.15                  // middle Y coordinate
		int startX = (int)(width * 0.8)             // start from right
		int endX = (int)(width * 0.2)               // swipe to left

		boolean found = false

		for (int i = 0; i < maxSwipes; i++) {

			try {
				// Get dynamic TestObject (parameterized in Object Repository)
				TestObject categoryObject = findTestObject(
						'Object Repository/Common Objects/Filter category on header',
						[('text') : categoryName]
						)

				// Check if element exists in current view
				if (Mobile.waitForElementPresent(categoryObject, 2)) {
					println("Found category: '${categoryName}' on attempt ${i+1}")
					Mobile.tap(categoryObject, 5)
					println("Tapped on category: '${categoryName}'")
					found = true
					break
				} else {
					println("🔄 '${categoryName}' not visible, swiping left... Attempt ${i+1}")
					Mobile.swipe(startX, startY, endX, startY)
				}
			} catch (Exception e) {
				println("⚠️ Exception occurred: ${e.message}")
				Mobile.swipe(startX, startY, endX, startY)
			}
		}

		if (!found) {
			println("❌ Could not find category '${categoryName}' after ${maxSwipes} swipes.")
		}
	}

	@Keyword
	def getExactScreenHalves() {
		// Get total screen width dynamically
		int screenWidth = Mobile.getDeviceWidth()
		println("Device Screen Width: ${screenWidth}px")

		// Calculate half width
		int halfWidth = screenWidth / 2

		// Define halves
		int firstHalfStart = 0
		int firstHalfEnd = halfWidth - 1
		int secondHalfStart = halfWidth
		int secondHalfEnd = screenWidth - 1

		println("Left Card: X = ${firstHalfStart} → ${firstHalfEnd}")
		println("Right Card: X = ${secondHalfStart} → ${secondHalfEnd}")

		//        // Return as a map for easy access
		//        return [
		//            'screenWidth'     : screenWidth,
		//            'halfWidth'       : halfWidth,
		//            'firstHalfStart'  : firstHalfStart,
		//            'firstHalfEnd'    : firstHalfEnd,
		//            'secondHalfStart' : secondHalfStart,
		//            'secondHalfEnd'   : secondHalfEnd
		//        ]
	}


	@Keyword
	def swipeUp() {
		int height = Mobile.getDeviceHeight()
		println("Phone Display height..."+height)
		int width = Mobile.getDeviceWidth()
		println("Phone Display width..."+width)
		int startX = width / 2
		println("User Swipe Up start Coordinate X..."+startX)
		int startY = (int)(height * 0.8)
		println("User Swipe Up start Coordinate Y..."+startY)
		int endY = (int)(height * 0.2)
		println("User Swipe left ends Coordinate Y..."+endY)
		Mobile.swipe(startX, startY, startX, endY)
		println("User scroll Up Starts from X..."+startX+ "...Starts Y..."+startY + "...Ends X..."+startX + "...Ends Y..."+endY)
	}

	@Keyword
	def swipeDown() {
		int height = Mobile.getDeviceHeight()
		println("Phone Display height..."+height)
		int width = Mobile.getDeviceWidth()
		println("Phone Display width..."+width)
		int startX = width / 2
		println("User Swipe Down start Coordinate X..."+startX)
		int startY = (int)(height * 0.2)
		println("User Swipe Down start Coordinate Y..."+startY)
		int endY = (int)(height * 0.8)
		println("User Swipe left ends Coordinate Y..."+endY)
		Mobile.swipe(startX, startY, startX, endY)
		println("User scroll Up Starts from X..."+startX+ "...Starts Y..."+startY + "...Ends X..."+startX + "...Ends Y..."+endY)
	}

	@Keyword
	def swipeRight() {
		int height = Mobile.getDeviceHeight()
		int width = Mobile.getDeviceWidth()
		int startY = height / 2
		int startX = (int)(width * 0.2)
		int endX = (int)(width * 0.8)
		Mobile.swipe(startX, startY, endX, startY)
		println("Swipe Right from X:" + startX + " → to X:" + endX + " at Y:" + startY)
	}

	@Keyword
	def swipeLeft() {
		int height = Mobile.getDeviceHeight()
		int width = Mobile.getDeviceWidth()
		int startY = height / 2
		int startX = (int)(width * 0.8)
		int endX = (int)(width * 0.2)
		Mobile.swipe(startX, startY, endX, startY)
		println("Swipe Left from X:" + startX + " → to X:" + endX + " at Y:" + startY)
	}


	@Keyword
	def swipeUpToText(String targetText, int maxSwipes = 10) {
		int height = Mobile.getDeviceHeight()
		int width = Mobile.getDeviceWidth()
		int startX = width / 2
		int startY = (int)(height * 0.8)
		int endY = (int)(height * 0.2)

		boolean found = false

		for (int i = 0; i < maxSwipes; i++) {
			try {
				// ✅ Use findTestObject with dynamic parameter
				TestObject textObj = findTestObject('Object Repository/Common Objects/text finder', [('text') : targetText])

				if (Mobile.waitForElementPresent(textObj, 2)) {
					println("Found text: " + targetText)
					Mobile.tap(textObj, 5)
					println("Tapped on text: " + targetText)
					found = true
					break
				} else {
					println("Text not found, swiping up... Attempt ${i+1}")
					Mobile.swipe(startX, startY, startX, endY)
				}
			} catch (Exception e) {
				println("Exception while finding text '${targetText}': ${e.message}")
			}
		}

		if (!found) {
			println("Could not find text '${targetText}' after ${maxSwipes} swipes.")
		}
	}


	@Keyword
	def swipeDownToText(String targetText, int maxSwipes = 10) {
		int height = Mobile.getDeviceHeight()
		int width = Mobile.getDeviceWidth()
		int startX = width / 2
		int startY = (int)(height * 0.2)
		int endY = (int)(height * 0.8)

		boolean found = false

		for (int i = 0; i < maxSwipes; i++) {
			try {
				// ✅ Use findTestObject with dynamic parameter
				TestObject textObj = findTestObject('Object Repository/Common Objects/text finder', [('text') : targetText])

				if (Mobile.waitForElementPresent(textObj, 2)) {
					println("Found text: " + targetText)
					Mobile.tap(textObj, 5)
					println("👉 Tapped on text: " + targetText)
					found = true
					break
				} else {
					println("Text not found, swiping up... Attempt ${i+1}")
					Mobile.swipe(startX, startY, startX, endY)
				}
			} catch (Exception e) {
				println("Exception while finding text '${targetText}': ${e.message}")
			}
		}

		if (!found) {
			println("Could not find text '${targetText}' after ${maxSwipes} swipes.")
		}
	}
}
