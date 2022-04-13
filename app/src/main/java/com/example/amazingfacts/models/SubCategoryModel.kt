package com.example.amazingfacts.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SubCategoriesModel {

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

         @SerializedName("fact_subcategory_name")
        @Expose
        var fact_subcategory_name: String? = null

        @SerializedName("subcategoryimage_url")
        @Expose
        var subcategoryimage_url: String? = null
    }
}