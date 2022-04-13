package com.example.amazingfacts.retrofit

import android.util.Log
import com.example.amazingfacts.base.CommomData
import com.example.amazingfacts.interfaces.CategoriesInterface
import com.example.amazingfacts.interfaces.SubCategoryInterface
import com.example.amazingfacts.models.CategoriesModel
import com.example.amazingfacts.models.SubCategoriesModel
import retrofit2.Call
import retrofit2.Callback

class Api {
    companion object {
        private val mInterface_method: Webservices =
            CommomData.getRetroInstance()!!.create(Webservices::class.java)


        fun getCategoriesApi(callback: CategoriesInterface) {
            val call: Call<CategoriesModel> = mInterface_method.getCategories()
            call.enqueue(object : Callback<CategoriesModel> {
                override fun onResponse(
                    call: Call<CategoriesModel>,
                    response: retrofit2.Response<CategoriesModel>
                ) {
                    Log.e("api_response : ", response.body().toString())
                    var model: CategoriesModel = response.body()!!
                    callback.onResponse(model)
                }

                override fun onFailure(call: Call<CategoriesModel>, t: Throwable) {
                    Log.e("api_response failure: ", t.message.toString())
                    callback.onFailure(t.message.toString())
                }
            })

        }


        fun getSubCategoriesApi(callback: SubCategoryInterface) {
            val call: Call<SubCategoriesModel> = mInterface_method.getSubCategories()
            call.enqueue(object : Callback<SubCategoriesModel> {
                override fun onResponse(
                    call: Call<SubCategoriesModel>,
                    response: retrofit2.Response<SubCategoriesModel>
                ) {
                    Log.e("api_response : ", response.body().toString())
                    var model: SubCategoriesModel = response.body()!!
                    callback.onResponse(model)
                }

                override fun onFailure(call: Call<SubCategoriesModel>, t: Throwable) {
                    Log.e("api_response failure: ", t.message.toString())
                    callback.onFailure(t.message.toString())
                }
            })

        }

    }
}
