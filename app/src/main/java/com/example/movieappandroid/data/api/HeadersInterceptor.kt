package com.example.movieappandroid.data.api

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original
            .newBuilder()
            .headers(HeadersBuilder.getCommonHeaders())
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}