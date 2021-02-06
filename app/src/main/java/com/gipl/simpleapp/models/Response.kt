package com.gipl.simpleapp.models

import java.lang.Exception

class Response(var status:STATUS,var data: Any?,var error:Throwable?) {

    companion object {
        @JvmStatic
        fun loading(vararg messageId: Int): Response {
            return Response(STATUS.LOADING, messageId, null)
        }
        @JvmStatic
        fun success(data: Any):Response{
            return Response(STATUS.SUCCESS,data,null)
        }
        @JvmStatic
        fun error(error: Exception?):Response{
            return Response(STATUS.FAILED,null,error)
        }
    }
    enum class STATUS{
        LOADING,
        SUCCESS,
        FAILED,
    }
}