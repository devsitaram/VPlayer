package com.edu.vplayer.features.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.edu.vplayer.features.domain.usecase.VideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class VideoViewModel @Inject constructor(private val videoUseCase: VideoUseCase): ViewModel(){


}