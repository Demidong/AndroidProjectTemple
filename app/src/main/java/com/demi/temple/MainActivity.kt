package com.demi.temple

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.demi.network.BitMapConvertFactory
import com.demi.network.HttpListResp
import com.demi.network.PACallback
import com.demi.network.RetrofitManager
import com.demi.temple.bean.Article
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitManager.getService(HttpService::class.java,factory = BitMapConvertFactory().create()).getImage()
            .enqueue(object : Callback<Bitmap> {
                override fun onFailure(call: Call<Bitmap>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<Bitmap>?, response: Response<Bitmap>) {
                    findViewById<ImageView>(R.id.iv_image).setImageBitmap(response.body())
                }

            })
        RetrofitManager.getService(HttpService::class.java).getWxArticleList()
            .enqueue(object : PACallback<List<Article>>() {
                override fun onSuccess(errorCode: Int, msg: String, data: List<Article>) {
                    for (a: Article in data) {
                        Log.e("TAG", a.name)
                    }
                }

                override fun onError(msg: String) {

                }

            })
    }
}