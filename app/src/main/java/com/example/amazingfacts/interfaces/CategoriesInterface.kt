package com.example.amazingfacts.interfaces

import com.example.amazingfacts.models.CategoriesModel

interface CategoriesInterface {
    fun onResponse(model : CategoriesModel)
    fun  onFailure(message : String)
}