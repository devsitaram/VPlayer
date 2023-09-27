package com.edu.vplayer.features.di

import android.content.Context
import androidx.activity.ComponentActivity
import okhttp3.Interceptor
import okhttp3.Response

class ClientInterceptor(private val context: Context): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val getSharedPreferences = context.getSharedPreferences("my_preferences", ComponentActivity.MODE_PRIVATE)
        val getUserDevice = getSharedPreferences.getString("login_screen", "")
        val request = chain.request().newBuilder()
            .addHeader("Authorization","Bearer $getUserDevice").build()
        return chain.proceed(request)
    }
}
