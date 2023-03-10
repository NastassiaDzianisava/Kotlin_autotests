package com.alfabank.qapp.core

import io.appium.java_client.AppiumDriver

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

open class AppiumSetup {
    companion object {
        lateinit var driver: AppiumDriver
        private val caps = DesiredCapabilities()

        private val appPackage = "com.alfabank.qapp"
        private val activityName = "com.alfabank.qapp"
        private val automationName = "UiAutomator2"
        private val platformName = "Android"
        private val serverUrl = "http://localhost:4723/wd/hub"

        @JvmStatic
        @BeforeAll
        fun setUp() {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName)
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName)
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage)
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityName)
            caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
            driver = AndroidDriver(URL(serverUrl), caps)
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            driver.quit()
        }
    }
}