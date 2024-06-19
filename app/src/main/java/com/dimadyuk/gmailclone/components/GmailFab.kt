package com.dimadyuk.gmailclone.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(
    scrollState: LazyListState,
) {
    val fullIcon by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex > 1
        }
    }
    ExtendedFloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        Row {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = null
            )
            AnimatedVisibility(visible = fullIcon) {
                Text(
                    text = "Compose", fontSize = 16.sp
                )
            }
        }
    }
}
