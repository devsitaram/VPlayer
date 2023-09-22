package com.edu.teachingnepal.features.classroom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.vplayer.features.presentation.ui.screen.classroom.tabs.MainTabsScreen
import com.edu.vplayer.features.presentation.ui.components.ButtonAppBarView
import com.edu.vplayer.ui.theme.Purple40

@Composable
fun ClassRoomScreenView(navController: NavHostController) {
    val listOfSubject = arrayOf(
        "Assessment",
        "Capstone Experience:Crafting Innovative Solutions in undergraduate Projects",
        "CC5007 Android Application Design and Development",
        "CC5068 Cloud Computing and the Internet of Things",
        "Cross-platform mobile application development with flutter",
        "CS5002 Software Engineering",
        "CS5003 Data Structures and Specialist Programming",
        "Practical Applications of Data Structures and Algorithms",
        "Work-Integrated Learning: Bridging the Gap between Academics and Industry "
    )
    var expandedSubject by remember { mutableStateOf(false) }
    var selectedSubjectItem by remember { mutableStateOf(listOfSubject[0]) }
    val listOfAllClass = arrayOf(
        "CS5002 Software Engineering_Assessment_AU_22",
        "CC5068 Cloud Computing and the Internet of Things_Assessment_AU_22",
        "CC5007 Android Application Design and Development_Assessment_AU_22",
        "CS5003 Data Structures and Specialist Programming_Assessment_AU_22",
    )
    var expandedClass by remember { mutableStateOf(false) }
    var selectedAllClassItem by remember { mutableStateOf(listOfAllClass[0]) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonAppBarView(navController)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DropDownTextFieldViewScreenSubject(
                label = "Subject",
                itemsList = listOfSubject,
                expanded = expandedSubject,
                selectedItem = selectedSubjectItem,
                onExpandedChange = { expandedSubject = !expandedSubject },
                onValueChange = { selectedSubjectItem = it },

                ) { expandedSubject = false }
            DropDownTextFieldViewScreenClass(
                label = "Class",
                itemsList = listOfAllClass,
                expanded = expandedClass,
                selectedItem = selectedAllClassItem,
                onExpandedChange = { expandedClass = !expandedClass },
                onValueChange = { selectedAllClassItem = it }
            ) { expandedClass = false }

        }
        MainTabsScreen()
    }
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DropDownTextFieldViewScreenSubject(
    label: String,
    itemsList: Array<String>,
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    var localExpanded by remember { mutableStateOf(expanded) }
    var localSelectedItem by remember { mutableStateOf(selectedItem) }

    // text fields
    ExposedDropdownMenuBox(
        expanded = localExpanded,
        onExpandedChange = {
            localExpanded = it
            onExpandedChange(it)
        }
    ) {
        // menu
        ExposedDropdownMenu(
            expanded = localExpanded,
            onDismissRequest = {
                localExpanded = false
                onDismissRequest()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            // all the items are added vertically
            itemsList.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(
                    onClick = {
                        localSelectedItem = selectedOption
                        localExpanded = false
                        onValueChange(selectedOption)
                    },
                ) {
                    Text(
                        text = selectedOption,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            lineHeight = 20.sp,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        // text field
        OutlinedTextField(
            value = localSelectedItem,
            onValueChange = { newValue ->
                localSelectedItem = newValue
                onValueChange(newValue)
            },
            label = { Text(text = label, color = Color.Gray) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = White,
                unfocusedBorderColor = White
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Computer,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Purple40
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = localExpanded)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                background = Color.White
            ),
            readOnly = true,
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .shadow(1.dp),
        )
    }
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DropDownTextFieldViewScreenClass(
    label: String,
    itemsList: Array<String>,
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    var localExpanded by remember { mutableStateOf(expanded) }
    var localSelectedItem by remember { mutableStateOf(selectedItem) }

    // text fields
    ExposedDropdownMenuBox(
        expanded = localExpanded,
        onExpandedChange = {
            localExpanded = it
            onExpandedChange(it)
        }
    ) {
        // menu
        ExposedDropdownMenu(
            expanded = localExpanded,
            onDismissRequest = {
                localExpanded = false
                onDismissRequest()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            // all the items are added vertically
            itemsList.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(
                    onClick = {
                        localSelectedItem = selectedOption
                        localExpanded = false
                        onValueChange(selectedOption)
                    },
                ) {
                    Text(
                        text = selectedOption,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            lineHeight = 20.sp,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        // text field
        OutlinedTextField(
            value = localSelectedItem,
            onValueChange = { newValue ->
                localSelectedItem = newValue
                onValueChange(newValue)
            },
            label = { Text(text = label, color = Color.Gray) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = White,
                unfocusedBorderColor = White
            ),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = localExpanded)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                background = White
            ),
            readOnly = true,
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .shadow(1.dp),
        )
    }
}