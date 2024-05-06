package com.example.virginmoneychallenge.ui.room

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneychallenge.domain.rooms.model.RoomModel
import com.example.virginmoneychallenge.domain.rooms.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel(){
    private var _roomList = MutableLiveData<List<RoomModel>>()
    val roomList : LiveData<List<RoomModel>> = _roomList
    private val _loading = MutableLiveData<Boolean>(true)
    val loading : LiveData<Boolean> = _loading
    val TAG = "TAG: RoomViewModel"
    init {
        getRoomList()
    }
    fun getRoomList(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.i(TAG,"getRoomList")
                _roomList.postValue(repository.getRoomsFromRemoteDataSource())
                _loading.postValue(false)
            }catch (e:Exception){
                Log.e(TAG,e.localizedMessage.toString())
            }
        }
    }

}