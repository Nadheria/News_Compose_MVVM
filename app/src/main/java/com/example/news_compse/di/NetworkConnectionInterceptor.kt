package com.example.news_compse.di
import android.content.Context
import com.example.news_compse.R
import com.example.news_compse.Utils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if (!Utils.isNetworkAvailable(applicationContext))
            throw NoInternetException(applicationContext.getString(R.string.s_make_sure_you_have_an_active_data_connection))

        val response: Response?

        try {
            response = chain.proceed(chain.request())
        } catch (e: Exception) {
            throw NoInternetException(applicationContext.getString(R.string.s_make_sure_you_have_an_active_data_connection))
        }
        return response
    }

}

class NoInternetException(e: String) : IOException(e)