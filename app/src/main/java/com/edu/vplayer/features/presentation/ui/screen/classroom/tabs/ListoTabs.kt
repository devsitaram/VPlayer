package com.edu.vplayer.features.presentation.ui.screen.classroom.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.features.classroom.tabs.Tabs_item
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainTabsScreen() {
    val tabs = listOf(
        Tabs_item.TeacherSession,
        Tabs_item.Assignments,
        Tabs_item.TeacherContent,
    )
    val pagerState = rememberPagerState()
    Column() {
        Tabs(tabs, pagerState)
        Tabs_content(tabs, pagerState)
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<Tabs_item>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.fillMaxWidth().padding(top = 1.dp), backgroundColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )

        }

    ) {
        tabs.forEachIndexed { index, tabsItem ->
            LeadingIconTab(
                selected = pagerState.currentPage ==index,
                onClick = { scope.launch {
                    pagerState.animateScrollToPage(index)
                } },
                icon = {},
                text = { Text(tabsItem.title, fontSize = 13.sp)})
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs_content(tabs: List<Tabs_item>, pagerState: PagerState) {
    HorizontalPager(state = pagerState,
        count = tabs.size) {
            page ->
        tabs[page].Screen()

    }
}
