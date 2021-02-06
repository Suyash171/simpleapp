package com.gipl.simpleapp.exceptions

import android.content.Context
import com.gipl.simpleapp.R
import com.tapcom.myapplication.exceptions.CustomException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

class ErrorFactory {
    companion object {
        @JvmStatic
        fun getErrorMsg(context: Context, error: Exception): String {
            return when (error.cause) {
                is ConnectException, is TimeoutException -> {
                    context.getString(R.string.no_internet)
                }
                is SocketTimeoutException -> {
                    context.getString(R.string.slow_network)
                }
                is CustomException -> {
                    (error.cause as CustomException).msg
                }
                else -> {
                    if (error.message != null) {
                        error.message.toString()
                    } else
                        context.getString(R.string.default_error)
                }
            }
        }
    }
}