package com.example.amazingfacts.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazingfacts.R
import com.example.amazingfacts.activities.MainActivity
import com.example.amazingfacts.adapter.CategoryAdapter
import com.example.amazingfacts.adapter.SubCategoryAdapter
import com.example.amazingfacts.base.CommomData.Companion.showMessage
import com.example.amazingfacts.interfaces.CategoriesInterface
import com.example.amazingfacts.interfaces.SubCategoryInterface
import com.example.amazingfacts.models.CategoriesModel
import com.example.amazingfacts.models.SubCategoriesModel
import com.example.amazingfacts.retrofit.Api
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_layout.*

class SubCategoryFragment : Fragment() {
    var mList: ArrayList<SubCategoriesModel.Datum> = ArrayList()
    lateinit var adapter: SubCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recyclerview_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()

        Api.getSubCategoriesApi(object : SubCategoryInterface {
            override fun onResponse(model: SubCategoriesModel) {
                mList.clear()
                progressLoader.visibility = View.GONE
                mRecyclerView.visibility = View.VISIBLE

                for (i in 0..model.getData()!!.size - 1) {
                    mList.add(model.getData()!![i]!!)
                }
                if (mList.size > 0) {

                    val mLayoutManager = LinearLayoutManager(activity)
                    mRecyclerView.layoutManager = mLayoutManager

                    adapter = SubCategoryAdapter(
                        requireActivity(),
                        mList,
                        object : SubCategoryAdapter.itemClicks {
                            override fun onItemSelected(model: SubCategoriesModel.Datum) {
                                showMessage(activity!!, "In Progress...")
                            }

                        })
                    mRecyclerView.adapter = adapter

                }
            }

            override fun onFailure(message: String) {
                showMessage(activity!!, message)
            }

        })
    }

    private fun setupData() {
        requireActivity().ivBack.visibility = View.VISIBLE
        progressLoader.visibility = View.VISIBLE
        mRecyclerView.visibility = View.GONE
    }
}