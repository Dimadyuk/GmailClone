package com.dimadyuk.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val title: String,
    val icon: ImageVector
) {
    data object Mail : BottomMenuData(
        title = "Mail",
        icon = Icons.Outlined.Mail,
    )

    data object Meet : BottomMenuData(
        title = "Meet",
        icon = Icons.Outlined.VideoCall,
    )
}