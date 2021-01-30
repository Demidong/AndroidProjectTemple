package com.demi.network

import android.graphics.Bitmap
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter
import java.io.ByteArrayOutputStream

class BitmapRequestBodyConvert : Converter<Bitmap, RequestBody> {
    override fun convert(bitmap: Bitmap): RequestBody {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return RequestBody.create(
            MediaType.parse("image/jpeg; charset=UTF-8"),
            stream.toByteArray()
        )
    }
}