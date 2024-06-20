package com.dimadyuk.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dimadyuk.gmailclone.R
import com.dimadyuk.gmailclone.ui.theme.GmailCloneTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    scope: CoroutineScope,
    openDialog: MutableState<Boolean>
) {
    Box(modifier = modifier.padding(10.dp)) {
        Card(
            modifier = Modifier
                .requiredHeight(50.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
                Text(
                    text = "Search in emails",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Transparent)
                        .clip(CircleShape)
                        .clickable {
                            openDialog.value = true
                        },
                    painter = painterResource(id = R.drawable.finger),
                    contentDescription = null
                )
            }
        }
        if (openDialog.value) {
            AccountsDialog(openDialog = openDialog)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeAppBarPreview() {
    GmailCloneTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        HomeAppBar(
            drawerState = drawerState,
            scope = scope,
            openDialog = remember { mutableStateOf(false) }
        )
    }
}
