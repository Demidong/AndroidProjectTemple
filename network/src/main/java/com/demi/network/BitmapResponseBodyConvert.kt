package com.demi.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import okhttp3.ResponseBody
import retrofit2.Converter

class BitmapResponseBodyConvert :Converter<ResponseBody,Bitmap> {

    override fun convert(value: ResponseBody): Bitmap {
       return BitmapFactory.decodeStream(value.byteStream())
    }
}