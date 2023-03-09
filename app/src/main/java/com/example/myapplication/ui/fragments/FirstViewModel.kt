package com.example.myapplication.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.CatModel
@Suppress("UNREACHABLE_CODE", "CAST_NEVER_SUCCEEDS")
class FirstViewModel : ViewModel() {

    private var list: MutableLiveData<ArrayList<CatModel>> = MutableLiveData()
    fun getCat(): MutableLiveData<ArrayList<CatModel>>{

        val catModelList:ArrayList<CatModel> = ArrayList()


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
        list.value = catModelList
        return list
    }
}