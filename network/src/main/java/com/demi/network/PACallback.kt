package com.demi.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class PACallback<T> : Callback<HttpResp<T>> {
    abstract fun onSuccess(errorCode:Int,msg:String,data:T)

    abstract fun onError(msg:String)

    override fun onResponse(call: Call<HttpResp<T>>, response: Response<HttpResp<T>>) {
        val resp =  response.body()
        if (resp.errorMsg == null){
            resp.errorMsg =""
        }
        if (resp.data == null){
            onError("数据为null")
            return
        }
        onSuccess(resp.errorCode,resp.errorMsg!!,resp.data!!)
    }

    override fun onFailure(call: Call<HttpResp<T>>, t: Throwable) {
        onError(t.message.toString())
    }
}