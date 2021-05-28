package com.wahidabd.androidpemula.ui

import androidx.lifecycle.ViewModel
import com.wahidabd.androidpemula.model.DataDummy
import com.wahidabd.androidpemula.model.Entity

class MainViewModel : ViewModel() {
    fun getAllData(): List<Entity> = DataDummy.dataDummy()

    //Detail
    private lateinit var id: String

    fun selectedId(id: String){
        this.id = id
    }

    fun setData(): Entity{
        lateinit var data: Entity
        val dataEntity = getAllData()

        for (i in dataEntity){
            if (i.id == this.id) data = i
        }
        return data
    }
}