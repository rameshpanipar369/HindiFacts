package com.example.amazingfacts.base

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.amazingfacts.base.Constants.Companion.BASEURL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

class CommomData {
    companion object {
        fun getRetroInstance(): Retrofit? {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val cookieManager = CookieManager()
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_NONE)

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
        }


        fun hideKeyboard(view: View) {
            val imm = ContextCompat.getSystemService(view.context, InputMethodManager::class.java)
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun showMessage(mActivity: Activity, message: String) {
            Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show()
        }


        /*fun showDialog(
            activity: Activity,
            id: String,
            mClickListner: SheetListAdapter.itemClick,
            exactPosition: Int
        ) {

            val dialog = Dialog(activity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.custom_dialog_layout)

            var tvDelete: TextView = dialog.findViewById(R.id.tvDelete)

            tvDelete.setOnClickListener {
                mClickListner.onItemDelete(id, exactPosition)
                dialog.dismiss()
            }
            dialog.show()

        }*/

    }
}
