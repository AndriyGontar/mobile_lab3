package com.example.lab3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lab3.dataprovider.MyDataProvider
import com.example.lab3.model.ItemTypeInterface
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {
    private var _myList: MutableLiveData<List<ItemTypeInterface>> =
        MutableLiveData<List<ItemTypeInterface>>().apply {
            value = emptyList()
        }
    val myList: LiveData<List<ItemTypeInterface>> = _myList
    init {
        var singer = MyDataProvider.getSingerData();
        viewModelScope.launch {
            _myList.value = MyDataProvider.getSongData().plus(singer);
        }
    }
}