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
import com.example.amazingfacts.base.CommomData.Companion.showMessage
import com.example.amazingfacts.interfaces.CategoriesInterface
import com.example.amazingfacts.models.CategoriesModel
import com.example.amazingfacts.retrofit.Api
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_layout.*

class CategoryFragment : Fragment() {
    var mList: ArrayList<CategoriesModel.Datum> = ArrayList()
    lateinit var adapter: CategoryAdapter

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

        Api.getCategoriesApi(object : CategoriesInterface {
            override fun onResponse(model: CategoriesModel) {
                mList.clear()
                progressLoader.visibility = View.GONE
                mRecyclerView.visibility = View.VISIBLE

                for (i in 0..model.getData()!!.size - 1) {
                    mList.add(model.getData()!![i]!!)
                }
                if (mList.size > 0) {

                    val mLayoutManager = LinearLayoutManager(activity)
                    mRecyclerView.layoutManager = mLayoutManager

                    adapter = CategoryAdapter(
                        requireActivity(),
                        mList,
                        object : CategoryAdapter.itemClick {
                            override fun onItemSelected(model: CategoriesModel.Datum) {
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .add(R.id.container, SubCategoryFragment()).commit()
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
        requireActivity().ivBack.visibility = View.GONE
        progressLoader.visibility = View.VISIBLE
        mRecyclerView.visibility = View.GONE
    }
}