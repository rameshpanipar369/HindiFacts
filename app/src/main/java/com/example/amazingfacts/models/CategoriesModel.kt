package com.example.amazingfacts.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class CategoriesModel {

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("data")
    @Expose
    private var data: List<Datum?>? = null

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getData(): List<Datum?>? {
        return data
    }

    fun setData(data: List<Datum?>?) {
        this.data = data
    }
    class Datum {
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("fact_category_name")
        @Expose
        var factCategoryName: String? = null

        @SerializedName("image_url")
        @Expose
        var factCategoryImg: String? = null
    }
}