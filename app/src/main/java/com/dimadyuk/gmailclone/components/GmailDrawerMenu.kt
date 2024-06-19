package com.dimadyuk.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dimadyuk.gmailclone.model.DrawerMenuData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GmailDrawerMenu(
    scrollState: ScrollState,
    drawerState: DrawerState,
    scope: CoroutineScope,
) {
    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.AllMail,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Settings,
        DrawerMenuData.Help
    )
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp),
            text = "Gmail",
            color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        menuList.forEach { item ->
            when {
                item.isDivider -> {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(12.dp)
                    )
                }
                item.isHeader -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp),
                        text = item.title!!,
                        color = Color.Gray,
                        fontSize = 16.sp,
                    )
                }
                else -> {
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = item.title!!,
                                color = Color.Black,
                                fontSize = 20.sp,
                            )
                        },
                        icon = {
                            item.icon?.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                            }
                        },
                        onClick = {
                            selectedItem = menuList.indexOf(item)
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        selected = selectedItem == menuList.indexOf(item)
                    )
                }
            }
        }
    }

}