package com.edu.vplayer.features.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.domain.model.SubjectState
import com.edu.vplayer.features.domain.usecase.SubjectUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@HiltViewModel
class SubjectViewModel @Inject constructor(private val subjectUseCase: SubjectUseCase) :
    ViewModel() {
    private val _subject = mutableStateOf(SubjectState())
    val subject: State<SubjectState> get() = _subject
    init {
        getSubjects()
    }
    private fun getSubjects() {
        subjectUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _subject.value = SubjectState(isLoading = true)
                }
                is Resource.Success -> {
                    _subject.value = SubjectState(isData = it.data)
                }
                is Resource.Error -> {
                    _subject.value = SubjectState(isError = it.message.toString())
                }

            }
        }.launchIn(viewModelScope)
    }
}