package com.alfabank.qapp.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.alfabank.qapp.core.AppiumSetup
import com.alfabank.qapp.helpers.GenerateRandomString
import com.alfabank.qapp.pages.Login
import com.alfabank.qapp.pages.LoginVariables
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LoginTest : AppiumSetup() {

    @Test
    fun  loginWithCorrectData() {
        Login.fillLoginData("Login", "Password")
        Login.submitBtnConfirm()

        val result = Login.getResultText()

        assertEquals("Вход в Alfa-Test выполнен", result)
    }

    @Test
    fun  checkInvalidLoginLotsSymbols() {
        val login = GenerateRandomString.getRandomString(0,50)
        Login.fillLoginData(login, "Password")

        val result = Login.getResultText()

        //В документе не указано сообщение при ошибке, пишу возможное допустимое
        assertEquals("Login can contain less than 50 symbols. Try again", result)
    }

    @Test
    fun  checkLoginInvalidSymbols() {
        Login.fillLoginData(LoginVariables.loginInvalidSymbols, "Password")

        val result = Login.getResultText()

        assertEquals("InvalidValue", result)
    }

    @Test
    fun  checkInvalidPasswordLotsSymbols() {
        val password = GenerateRandomString.getRandomString(0,50)
        Login.fillLoginData("Login", "Password")

        val result = Login.getResultText()

        //В документе не указано сообщение при ошибке, пишу возможное допустимое
        assertEquals("Password can contain less than 50 symbols. Try again", result)
    }

    //На случай, если стоит ограничение длины input
    @Test
    fun  checkLoginMaxLength() {
        val login = GenerateRandomString.getRandomString(0,51)
        Login.fillLoginData(login, "Password")

        val result = Login.getLogin()

        assertEquals(50, result.length)
    }

    @Test
    fun  loginIsInvalid() {
        val login = GenerateRandomString.getRandomString(0,20)
        Login.fillLoginData(login, "Password")

        val result = Login.getResultText()

        assertEquals("Введены неверные данные", result)
    }
}
