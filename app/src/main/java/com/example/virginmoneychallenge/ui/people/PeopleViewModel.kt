package com.example.virginmoneychallenge.ui.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneychallenge.domain.people.model.PeopleDTO
import com.example.virginmoneychallenge.domain.people.repository.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val peopleRepository: PeopleRepository): ViewModel() {
    private var _people = MutableLiveData<List<PeopleDTO>>()
    val people : LiveData<List<PeopleDTO>> = _people
    val TAG = "TAG: PeopleViewModel"
    private val _loading = MutableLiveData<Boolean>(true)
    val loading : LiveData<Boolean> = _loading
    init {
        getPeople()
    }
    private fun getPeople(){
        Log.i(TAG, "getPeople Started")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _people.postValue(peopleRepository.getPeopleListFromRemoteDataSource())
                _loading.postValue(false)
            }catch (e:Exception){
                Log.e(TAG, e.localizedMessage)
            }
        }
    }
}