package com.enriqif.globallogicapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enriqif.domain.common.Resource
import com.enriqif.domain.use_case.GetNotebooksUseCase
import com.enriqif.globallogicapp.common.Constants.ERROR_MESSAGE_ON_LOADING
import com.enriqif.globallogicapp.model.NotebookListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NotebookViewModel @Inject constructor(
    private val getNotebooksUseCase: GetNotebooksUseCase
) : ViewModel() {

    private val _state = MutableLiveData<NotebookListState>()
    val state : LiveData<NotebookListState> = _state

    init {
        getNotebooks()
    }

    private fun getNotebooks() {
        getNotebooksUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = NotebookListState(notebooks = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = NotebookListState(error = result.message ?: ERROR_MESSAGE_ON_LOADING)
                }
                is Resource.Loading -> {
                    _state.value = NotebookListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}