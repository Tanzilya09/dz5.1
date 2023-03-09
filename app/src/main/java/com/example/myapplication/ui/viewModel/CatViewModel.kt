package com.example.myapplication.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.model.CatModel

class CatViewModel: ViewModel() {

    private val catModelList:ArrayList<CatModel> = ArrayList()

    fun getListOfCatHTP(): ArrayList<CatModel> {

        catModelList.clear()
        catModelList.add(
            CatModel(
                "https://http.cat/100",
                "Continue"
            )
        )

        catModelList.add(
            CatModel(
                "https://http.cat/101",
                "Switching Protocols"
            )
        )
        catModelList.add(
            CatModel(
                "https://http.cat/201",
                "Created"
            )
        )
        catModelList.add(
            CatModel(
                "https://http.cat/203",
                "Non-Authoritative Information"
            )
        )
        catModelList.add(
            CatModel(
                "https://http.cat/301",
                "Moved Permanently"
            )
        )
        return catModelList
    }

}