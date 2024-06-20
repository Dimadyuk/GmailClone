package com.dimadyuk.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.dimadyuk.gmailclone.components.GmailDrawerMenu
import com.dimadyuk.gmailclone.components.GmailFab
import com.dimadyuk.gmailclone.components.HomeAppBar
import com.dimadyuk.gmailclone.components.HomeBottomMenu
import com.dimadyuk.gmailclone.components.MailList
import com.dimadyuk.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GmailCloneTheme {
                val paddingTop = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scrollState = rememberScrollState()
                val listScrollState = rememberLazyListState()
                val scope = rememberCoroutineScope()

                val openDialog = remember { mutableStateOf(false) }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            GmailDrawerMenu(
                                scrollState = scrollState,
                                drawerState = drawerState,
                                scope = scope
                            )
                        }
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            HomeAppBar(
                                modifier = Modifier
                                    .padding(top = paddingTop),
                                drawerState = drawerState,
                                scope = scope,
                                openDialog = openDialog
                            )
                        },
                        bottomBar = {
                            HomeBottomMenu()
                        },
                        content = { padding ->
                            MailList(
                                scrollState = listScrollState,
                                paddingValues = padding
                            )
                        },
                        floatingActionButton = {
                            GmailFab(scrollState = listScrollState)
                        }
                    )
                }
            }
        }
    }
}
