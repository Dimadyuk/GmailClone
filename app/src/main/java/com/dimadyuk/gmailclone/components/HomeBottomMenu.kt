package com.dimadyuk.gmailclone.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dimadyuk.gmailclone.model.BottomMenuData

@Composable
fun HomeBottomMenu() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        contentColor = Color.Black
    ) {

        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = index == navigationSelectedItem,
                onClick = {
                    navigationSelectedItem = index
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) })
        }
    }
}