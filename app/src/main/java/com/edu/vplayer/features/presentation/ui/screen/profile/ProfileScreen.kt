package com.edu.vplayer.features.presentation.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DatasetLinked
import androidx.compose.material.icons.filled.DownloadForOffline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Redeem
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.edu.vplayer.R
import com.edu.vplayer.features.data.resource.local.ProfileEntity
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.DEFAULT_IMAGE_URL
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.IMAGE_BASE_URL
import com.edu.vplayer.features.presentation.ui.components.IconView
import com.edu.vplayer.features.presentation.ui.components.TextView
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList
import com.edu.vplayer.features.presentation.viewModel.ProfileViewModel
import com.edu.vplayer.ui.theme.BlueGrey
import com.edu.vplayer.ui.theme.skyBlue
import com.edu.vplayer.ui.theme.skyGreen

@Composable
fun ProfileViewScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val profileResult = profileViewModel.profile.value
    if (profileResult.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (profileResult.isError.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            TextView(text = profileResult.isError, color = Color.Red)
        }
    }
    profileResult.isData?.let {
        val profile = profileResult.isData.result
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ProfileCard(
                userId = profile?.userId.toString(),
                fullName = profile?.fullName.toString(),
                role = profile?.role.toString(),
                emailAddress = profile?.emailAddress.toString(),
                schoolName = profile?.schoolName.toString(),
                location = profile?.location.toString(),
                imageUrl = IMAGE_BASE_URL + profile?.schoolPhotoUrl,//profile?.schoolPhotoUrl.toString(),
                navController = navController
            )

            profileViewModel.insertUserDetails(
                profileEntity = ProfileEntity(
                    name = profile?.fullName.toString(),
                    email = profile?.emailAddress.toString(),
                    collegeName = profile?.schoolName.toString(),
                    location = profile?.location.toString()
                )
            )
        }
    }
}

@Composable
fun ProfileCard(
    userId: String,
    fullName: String,
    role: String,
    emailAddress: String,
    schoolName: String,
    location: String,
    imageUrl: String,
    navController: NavController
) {
    val color = skyGreen
    val transparent = color.copy(alpha = 0.10f)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Card(
                modifier = Modifier.padding(top = 10.dp, start = 5.dp),
                shape = ShapeDefaults.ExtraLarge,
                colors = CardDefaults.cardColors(transparent)
            ) {
                IconButton(onClick = { navController.navigate(ScreenList.LogoutScreen.route) }) {
                    Icon(
                        imageVector = Icons.Default.PersonOutline, contentDescription = null,
                        modifier = Modifier
                            .wrapContentWidth()
                            .size(60.dp)
                            .padding(10.dp),
                        tint = skyGreen
                    )
                }
            }
            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                TextView(text = fullName, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                TextView(
                    text = emailAddress,
                    fontSize = 14.sp,
                    modifier = Modifier.width(235.dp)
                )
            }

            Card(
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp),
                shape = CircleShape,
                border = BorderStroke(1.dp, skyBlue),
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Edit, contentDescription = null,
                        modifier = Modifier.padding(5.dp), tint = skyBlue

                    )
                }

            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(BlueGrey)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
//                    AsyncImage(
//                        model = imageUrl,//null = painterResource(id = R.mipmap.ic_islington),
//                        contentDescription = null, modifier = Modifier.padding(10.dp)
//                    )

                    Image(
                        painter = painterResource(id = R.mipmap.ic_islington),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                    )

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        TextView(text = schoolName, fontWeight = FontWeight.Bold)
                        TextView(text = location)

                    }
                }

            }
        }

        ListOfRow(icon = Icons.Default.AccountCircle, title = "Account")
        ListOfRow(icon = Icons.Default.Note, title = "Notices")
        ListOfRow(icon = Icons.Default.DownloadForOffline, title = "Downloads")
        ListOfRow(icon = Icons.Default.DatasetLinked, title = "Linked Guardian Accounts")
        ListOfRow(icon = Icons.Default.Share, title = "Linked Social Accounts")
        ListOfRow(icon = Icons.Default.ManageAccounts, title = "Manage Subscriptions")
        ListOfRow(icon = Icons.Default.Payment, title = "Payment Transactions Status")
        ListOfRow(icon = Icons.Default.Settings, title = "Pop-up Guide Preferences")
        ListOfRow(icon = Icons.Default.Redeem, title = "Redeem Coupon")
        ListOfColumn(
            icon = Icons.Default.TextSnippet,
            title = "TestPaper",
            "Available On Web Version ",
            color = Color.LightGray
        )
        ListOfColumn(
            icon = Icons.Default.Message,
            title = "Chatroom",
            "Available On Web Version",
            color = Color.LightGray
        )
        ListOfColumn(
            icon = Icons.Default.Info,
            title = "mySecondTeacher Nepal",
            "v2.03.00 (60)",
            color = Color.DarkGray
        )


    }
}

@Composable
fun ListOfRow(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit = { }
) {
    Column(modifier = Modifier
        .clickable { onClick() }
    ) {
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconView(imageVector = icon, contentDescription = null, modifier = Modifier)
            TextView(text = title, modifier = Modifier.padding(start = 5.dp))
        }
        Spacer(modifier = Modifier.padding(2.dp))
    }
}


@Composable
fun ListOfColumn(
    icon: ImageVector,
    title: String,
    subTitle: String,
    color: Color
) {
    Divider()
    Row(
        modifier = Modifier
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconView(imageVector = icon, contentDescription = null, tint = Color.LightGray)
        Column(modifier = Modifier.padding(start = 10.dp)) {
            TextView(text = subTitle, color = color)
            TextView(
                text = subTitle,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}
