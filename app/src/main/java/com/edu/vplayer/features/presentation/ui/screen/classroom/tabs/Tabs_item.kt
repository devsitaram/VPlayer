package com.edu.teachingnepal.features.classroom.tabs

import androidx.compose.runtime.Composable
import com.edu.vplayer.features.presentation.ui.screen.classroom.tabs.AssignmentsView
import com.edu.vplayer.features.presentation.ui.screen.classroom.tabs.TeachersContentView
import com.edu.vplayer.features.presentation.ui.screen.classroom.tabs.TeachersSessionView

typealias  MyFunction = @Composable () -> Unit
sealed class Tabs_item(
    var title: String,
    var Screen : MyFunction
){
    object TeacherSession: Tabs_item("Teacher's Session" ,{ TeachersSessionView() })
    object Assignments: Tabs_item("Assignments" ,{ AssignmentsView() })
    object TeacherContent: Tabs_item("Teacher's Content" ,{ TeachersContentView() })
}
