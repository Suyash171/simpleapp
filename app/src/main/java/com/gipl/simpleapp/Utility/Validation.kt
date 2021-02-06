package com.gipl.simpleapp.Utility

import android.util.Patterns

class Validation {
    companion object {
        fun validateEmailId(emailId: String): String? {
            var error: String? = null;
            if (emailId.isEmpty()) {
                error = "Please enter email id."
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
                error = "Please enter valid email id"
            }
            return error
        }

        const val PASS_LENGTH = 8
        fun validatePassword(password: String): String? {
            if (password.length < 8) {
                return "Password should be  min $PASS_LENGTH character long"
            }
            return null
        }
    }


}