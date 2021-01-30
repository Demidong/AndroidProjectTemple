package com.demi.network

open class HttpResp<T> {
    var errorCode = 0
    var errorMsg: String? = null
    var data: T? = null

}