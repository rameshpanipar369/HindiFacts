package com.example.amazingfacts.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazingfacts.R
import com.example.amazingfacts.models.SubCategoriesModel
import com.squareup.picasso.Picasso

class SubCategoryAdapter(
    val context: Activity,
    val mList: ArrayList<SubCategoriesModel.Datum>,
    val mClickListner: itemClicks
) :
    RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCategoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
        var ivCategoryImage: ImageView = itemView.findViewById(R.id.ivCategoryImage)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_row_item, parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(mList[position].subcategoryimage_url).into(holder.ivCategoryImage)
        holder.tvCategoryName.text = mList[position].fact_subcategory_name
        holder.itemView.setOnClickListener(View.OnClickListener {
            mClickListner.onItemSelected(mList[position])

        })

    }

    override fun getItemCount(): Int {
        return mList.size
    }


    interface itemClicks {
        fun onItemSelected(model: SubCategoriesModel.Datum)

    }
}