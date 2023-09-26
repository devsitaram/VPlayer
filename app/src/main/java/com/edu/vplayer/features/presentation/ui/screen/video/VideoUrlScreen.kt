package com.edu.vplayer.features.presentation.ui.screen.video

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.edu.vplayer.features.data.resource.local.VideoImageEntity
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.IMAGE_BASE_URL
import com.edu.vplayer.features.presentation.ui.components.TextView
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList
import com.edu.vplayer.features.presentation.viewModel.VideoUrlViewModel

@Composable
fun VideoUrlViewScreen(
    videoId: Int?,
    subjectName: String?,
    navController: NavController,
    videoUrlViewModel: VideoUrlViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val videoUrlResult = videoUrlViewModel.vUrl.value


    LaunchedEffect(key1 = videoId) {
        videoUrlViewModel.getVideoUrlData(videoId)
    }
    if (videoUrlResult.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (videoUrlResult.isError.isNotBlank()) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            TextView(text = videoUrlResult.isError, color = Color.Red)
        }
    }
    TextView(text = subjectName.toString())
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        videoUrlResult.isData?.chapters?.forEach { chaptersItem ->
            chaptersItem?.topics?.forEach { topicsItem ->
                topicsItem?.videos?.forEach { videosItem ->
                    item {
                        val imageUrl = IMAGE_BASE_URL + videosItem?.thumbNailUrl
                        val watchTime = videosItem?.videoDuration ?: ""
                        val videoTitle = videosItem?.videoTitle ?: ""
                        val id = videoUrlResult.isData?.id
                        val completion = videoUrlResult.isData?.completion
                        val photoUrl = videoUrlResult.isData?.photoUrl
                        val chapters = videoUrlResult.isData?.chapters
                        val subjectDescription = videoUrlResult.isData?.subjectDescription
                        val totalVideoWatchedTimeInSeconds =
                            videoUrlResult.isData?.totalVideoWatchedTimeInSeconds
                        val subjectName = videoUrlResult.isData?.subjectName
                        val mastery = videoUrlResult.isData?.mastery
                        VideoUrlItems(
                            imageUrl = imageUrl,
                            videoDuration = watchTime.toDouble(),
                            videoTitle = videoTitle,
                            onClickAction= {
                                navController.navigate(ScreenList.VideoScreen.route)
                            }

                        )

                        LaunchedEffect(key1 = id, block = {
                            val listOfVideoImage = listOf(
                                VideoImageEntity(
                                    id = id,
                                    completion = completion,
                                    photoUrl = photoUrl,
                                    chapters = chapters,
                                    subjectDescription = subjectDescription,
                                    totalVideoWatchedTimeInSeconds = totalVideoWatchedTimeInSeconds,
                                    subjectName = subjectName,
                                    mastery = mastery
                                )
                            )
                            videoUrlViewModel.insertVideoImageDetails(listOfVideoImage)
                        })
                    }
                }

            }
        }
    }
}
@Composable
fun VideoUrlItems(
    imageUrl: String?,
    videoDuration: Double,
    videoTitle: String?,
    onClickAction: () -> Unit,
    ) {
    var totalTime by remember { mutableStateOf("") }
    LaunchedEffect(videoDuration) {
        val seconds = (videoDuration.plus(0.5)).toInt()
        val minutes = seconds / 60
        val remainSecond = seconds % 60
        totalTime = String.format("%02d:%02d", minutes, remainSecond)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Box(modifier = Modifier.wrapContentSize().clickable { onClickAction() }, contentAlignment = Alignment.BottomCenter) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                Modifier
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), horizontalArrangement = Arrangement.End
                ) {
                    TextView(
                        text = totalTime, color = Color.White,
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(5.dp),
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    )
                }
            }
        }
        TextView(
            text = videoTitle.toString(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(textAlign = TextAlign.Center)
        )
    }
}