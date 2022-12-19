package com.alfabank.qapp.helpers

class GenerateRandomString {
    companion object {
        fun getRandomString(start: Int, length: Int): String {
            val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9') + " .,/-'_"
            return (start..length)
                .map { charset.random() }
                .joinToString("")
        }
    }
}