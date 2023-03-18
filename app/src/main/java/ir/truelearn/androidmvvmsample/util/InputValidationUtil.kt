package ir.truelearn.androidmvvmsample.util

import androidx.core.text.isDigitsOnly

object InputValidationUtil {

    fun isValidPhoneNumber(input: String): Boolean {
        return input.isNotEmpty()
                && input.isNotBlank()
                && input.isDigitsOnly()
                && input.startsWith("09")
                && input.length == 11
    }
    fun isValidNumber(input: String): Boolean {
        return input.isNotEmpty()
                && input.isNotBlank()
                && input.isDigitsOnly()
    }

    fun isValidEmpty(input: String): Boolean {
        return input.isNotEmpty()
                && input.isNotBlank()
    }

    fun isValidEmail(input: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    fun isValidPassword(input: String): Boolean {
        return input.isNotEmpty() && input.isNotBlank() && input.length >= 6
    }
}