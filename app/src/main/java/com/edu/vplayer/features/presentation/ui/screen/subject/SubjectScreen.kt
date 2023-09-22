package com.edu.vplayer.features.presentation.ui.screen.subject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.DEFAULT_IMAGE_URL
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.IMAGE_BASE_URL
import com.edu.vplayer.features.presentation.ui.components.ButtonAppBarView
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList
import com.edu.vplayer.features.presentation.viewModel.SubjectViewModel
import com.edu.vplayer.ui.theme.White20

@Composable
fun SubjectViewScreen(
    navController: NavController,
    subjectViewModel: SubjectViewModel = hiltViewModel()
) {
    val subjectResult = subjectViewModel.subject.value
    if (subjectResult.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            // indicator
            CircularProgressIndicator()
        }
    }
    if (subjectResult.isError.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            // error message
            Text(text = subjectResult.isError)
        }
    }

    subjectResult.isData?.let {
        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonAppBarView(navController)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
//                .background(Color.White)
                .padding(top = 50.dp , bottom = 40.dp,), contentAlignment = Alignment.Center
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(it) {
                    SubjectCard(
                        id = it?.id.toString(),
                        title = it?.name.toString(),
                        descriptions = it?.description.toString(),
                        imageUrl = IMAGE_BASE_URL + if (it?.photoUrl.isNullOrEmpty()) DEFAULT_IMAGE_URL else it?.photoUrl.toString(),
                        onClickAction = { navController.navigate(ScreenList.VideoScreen.route) }
                    )
                }
            }
        }
    }
}

@Composable
fun SubjectCard(
    id: String,
    title: String,
    descriptions: String,
    imageUrl: String,
    onClickAction: () -> Unit
) {


        Card(
            modifier = Modifier
                .wrapContentWidth()
                .clickable { onClickAction() },
            colors = CardDefaults.cardColors(
                Color.White
            ),
            border = BorderStroke(1.dp, White20),

            ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Column(
                    modifier = Modifier
                        .shadow(0.5.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = title, style = TextStyle(fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = descriptions, color = Color.LightGray)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(1.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Preview,
                            contentDescription = null, modifier = Modifier, tint = Color.Blue
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = "View Package Details", color = Color.Blue)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
    }
