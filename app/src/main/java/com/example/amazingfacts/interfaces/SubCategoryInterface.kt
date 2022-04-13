package com.example.amazingfacts.interfaces

import com.example.amazingfacts.models.CategoriesModel
import com.example.amazingfacts.models.SubCategoriesModel

interface SubCategoryInterface {
        fun onResponse(model : SubCategoriesModel)
        fun  onFailure(message : String)

}