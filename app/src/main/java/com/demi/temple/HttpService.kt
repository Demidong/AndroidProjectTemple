package com.demi.temple

import android.graphics.Bitmap
import com.demi.network.HttpListResp
import com.demi.network.HttpResp
import com.demi.network.PACallback
import com.demi.temple.bean.Article
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HttpService {
    @GET("wxarticle/chapters/json")
    fun getWxArticleList(): Call<HttpResp<List<Article>>>


    @GET("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa0.att.hudong.com%2F52%2F62%2F31300542679117141195629117826.jpg&refer=http%3A%2F%2Fa0.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614055523&t=72035aa022ce4b0c510e111c66c7d739")
    fun getImage() : Call<Bitmap>

}