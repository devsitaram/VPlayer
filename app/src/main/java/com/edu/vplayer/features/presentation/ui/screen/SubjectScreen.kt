package com.edu.vplayer.features.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.vplayer.R
import com.edu.vplayer.features.presentation.ui.components.ContentCardView
import com.edu.vplayer.features.presentation.ui.components.TextView

@Composable
fun SubjectViewScreen(navHostController: NavHostController) {

    val listOfSubject = mutableListOf<SubjectLists>()
    listOfSubject.add(
        SubjectLists(
            painter = painterResource(id = R.mipmap.img_11_biology),
            topic = "Grade 10: Biology",
            description = "Grade 10 syllabus: Economics",
        )
    )
    listOfSubject.add(
        SubjectLists(
            painter = painterResource(id = R.mipmap.img_11_chimestry),
            topic = "Grade 11: Chemistry",
            description = "Grade 11 syllabus: Chemistry, Social Studies, Mathematics, Business Studies, Accounts, Economics, Computer Science.",
        )
    )
    listOfSubject.add(
        SubjectLists(
            painter = painterResource(id = R.mipmap.img_11_science),
            topic = "Grade 11: Science",
            description = "Grade 11 syllabus: Nepali, English, Social Studies, Mathematics, Physics Chemistry, Biology, Computer Science.",
        )
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            // this is the screen
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 55.dp),
            ) {
                // contents
                TextView(
                    text = "Subject",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(top = 20.dp, bottom = 15.dp)
                )

                // column content
                LazyColumn {
                    items(listOfSubject) { item ->
                        ContentCardView(
                            painter = item.painter,
                            topic = item.topic,
                            description = item.description,
                            onClickable = {
//                                val subject = SubjectDetail(topic = item.topic, description = item.description)
//                                subjectDetailsViewModel.addSubjectDetails(newSubjectDetails = subject)
                                navHostController.navigate(ScreenList.VideoScreen.route)
                            }
                        )
                    }
                }
            }
        }
    }
}

data class SubjectLists(
    val painter: Painter,
    val topic: String,
    val description: String,
)


////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_10_economic),
////topic = "Grade 10: Economics",
////description = "Grade 10 syllabus: Economics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_non_science),
////topic = "Grade 11: Non-Science",
////description = "Grade 11 syllabus: Nepali, English, Social Studies, Mathematics, Business Studies, Accounts, Economics, Computer Science.",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_science),
////topic = "Grade 11: Science",
////description = "Grade 11 syllabus: Nepali, English, Social Studies, Mathematics, Physics Chemistry, Biology, Computer Science.",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_biology),
////topic = "Grade 11: Biology",
////description = "Grade 11 syllabus: Biology",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_business),
////topic = "Grade 11: Business Studies",
////description = "Grade 11 syllabus: Business Studies",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_chimestry),
////topic = "Grade 11: Chemistry",
////description = "Grade 11 syllabus: Chemistry",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_computer_science),
////topic = "Grade 11: Computer Sciences",
////description = "Grade 11 syllabus: Computer Science",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_economic),
////topic = "Grade 11: Economics",
////description = "Grade 11 syllabus: Economics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_english),
////topic = "Grade 11: English",
////description = "Grade 11 syllabus: English",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_mathmetices),
////topic = "Grade 11: Mathematics",
////description = "Grade 11 syllabus: Mathematics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_nepali),
////topic = "Grade 11: Nepali",
////description = "Grade 11 syllabus: Nepali",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_physic),
////topic = "Grade 11: Physics",
////description = "Grade 11 syllabus: Physics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_principal_of_accounting),
////topic = "Grade 11: Principal of Accounting",
////description = "Grade 11 syllabus: Principal of Accounting",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_11_social_studies),
////topic = "Grade 11: Social Studies and Life Skill Education",
////description = "Grade 11 syllabus: Social Studies and Life Skill Education",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_biology),
////topic = "Grade 12: Biology",
////description = "Grade 12 syllabus: Biology",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_chemistry),
////topic = "Grade 12: Chemistry",
////description = "Grade 12 syllabus: Chemistry",
////)
////)
////
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_economic),
////topic = "Grade 12: Economic",
////description = "Grade 12 syllabus: Economics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_english),
////topic = "Grade 12: English",
////description = "Grade 12 syllabus: English",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_mathmetices),
////topic = "Grade 12: Mathematics",
////description = "Grade 12 syllabus: Mathematics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_nepali),
////topic = "Grade 12: Nepali",
////description = "Grade 12 syllabus: Nepali",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_physics),
////topic = "Grade 12: Physics",
////description = "Grade 12 syllabus: Physics",
////)
////)
////listOfSubject.add(
////SubjectLists(
////painter = painterResource(id = R.mipmap.img_12_principalof_accounting),
////topic = "Grade 12: Principal of Accounting",
////description = "Grade 12 syllabus: Principal of Accounting",
////)
////)