package com.example.aast_ratings.APIState

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StateViewModel:ViewModel() {

    var campuses = mutableStateOf<Int>(1)
    var colleges = mutableStateOf<Int>(1)
    var lecturers = mutableStateOf<Int>(1)
    var reviews = mutableStateOf<Int>(1)

    init {
        viewModelScope.launch {
            getStateInfo()
        }
    }

    private suspend fun getStateInfo(){
        var getPropertiesDeferredImage = stateDetails.stateretrofitService.getProperties()
        try{
            var listResult = getPropertiesDeferredImage.await()
            campuses.value = listResult.Campuses
            colleges.value = listResult.Colleges
            lecturers.value = listResult.Lecturers
            reviews.value = listResult.Reviews
                
            println("niceeeeeeeeeeeeeeeeee"+listResult.toString())
        }catch (e:Exception){
            println("state API Faileddddddddddddddddddddddddddddddddddddddddddddd"+e)
        }
    }

    fun getcampuses(): String? {
        println("valuee of camp"+campuses.value.toString())
        return campuses.value.toString()
    }
    fun getcolleges(): String? {
        return colleges.value.toString()
    }
    fun getlecturers(): String? {
        return lecturers.value.toString()
    }
    fun getreviews(): String? {
        return reviews.value.toString()
    }
}