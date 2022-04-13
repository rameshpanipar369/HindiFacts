package com.example.amazingfacts.retrofit

import com.example.amazingfacts.base.Constants.Companion.FactCategoryView
import com.example.amazingfacts.base.Constants.Companion.SubFactCategoryView
import com.example.amazingfacts.models.CategoriesModel
import com.example.amazingfacts.models.SubCategoriesModel
import retrofit2.Call
import retrofit2.http.GET

interface Webservices {
    @GET(FactCategoryView)
    fun getCategories(): Call<CategoriesModel>

    @GET(SubFactCategoryView)
    fun getSubCategories(): Call<SubCategoriesModel>


}