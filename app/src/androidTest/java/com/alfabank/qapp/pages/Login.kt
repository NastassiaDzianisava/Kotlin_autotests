package com.alfabank.qapp.pages

import com.alfabank.qapp.core.AppiumSetup
import org.openqa.selenium.By

open class Login {
    companion object {
        fun fillLoginData(login: String, password: String) {
            AppiumSetup.driver.findElement(By.id(LoginViewIds.LOGIN)).sendKeys(login)
            AppiumSetup.driver.findElement(By.id(LoginViewIds.PASSWORD)).sendKeys(password)
        }

        fun submitBtnConfirm() {
            AppiumSetup.driver.findElement(By.id(LoginViewIds.SUBMIT)).click()
        }

        fun getResultText(): String {
            return AppiumSetup.driver.findElement(By.className("android.widget.TextView")).text
        }

        fun getLogin() :String{
            return AppiumSetup.driver.findElement(By.id(LoginViewIds.LOGIN)).text
        }
    }
}