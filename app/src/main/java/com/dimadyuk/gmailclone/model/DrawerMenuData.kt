package com.dimadyuk.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Drafts
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Snooze
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val title: String? = null,
    val icon: ImageVector? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false,
) {

    data object AllInboxes : DrawerMenuData(
        title = "All inboxes",
        icon = Icons.Outlined.AllInbox,
    )

    data object Primary : DrawerMenuData(
        title = "Primary",
        icon = Icons.Outlined.Inbox,
    )

    data object Social : DrawerMenuData(
        title = "Social",
        icon = Icons.Outlined.Person,
    )

    data object Promotions : DrawerMenuData(
        title = "Promotions",
        icon = Icons.Outlined.Tag,
    )

    data object Starred : DrawerMenuData(
        title = "Starred",
        icon = Icons.Outlined.StarOutline,
    )

    data object Snoozed : DrawerMenuData(
        title = "Snoozed",
        icon = Icons.Outlined.Snooze,
    )

    data object Important : DrawerMenuData(
        title = "Important",
        icon = Icons.AutoMirrored.Outlined.Label,
    )

    data object Sent : DrawerMenuData(
        title = "Sent",
        icon = Icons.AutoMirrored.Outlined.Send,
    )

    data object Schedule : DrawerMenuData(
        title = "Schedule",
        icon = Icons.Outlined.Schedule,
    )

    data object Outbox : DrawerMenuData(
        title = "Outbox",
        icon = Icons.Outlined.Outbox,
    )

    data object Draft : DrawerMenuData(
        title = "Draft",
        icon = Icons.Outlined.Drafts,
    )

    data object AllMail : DrawerMenuData(
        title = "All mail",
        icon = Icons.Outlined.Mail,
    )

    data object Calendar : DrawerMenuData(
        title = "Calendar",
        icon = Icons.Outlined.CalendarToday,
    )

    data object Contacts : DrawerMenuData(
        title = "Contacts",
        icon = Icons.Outlined.Contacts,
    )

    data object Settings : DrawerMenuData(
        title = "Settings",
        icon = Icons.Outlined.Settings,
    )

    data object Help : DrawerMenuData(
        title = "Help & feedback",
        icon = Icons.AutoMirrored.Outlined.Help,
    )

    data object Divider : DrawerMenuData(
        isDivider = true
    )

    data object HeaderOne : DrawerMenuData(
        isHeader = true,
        title = "ALL LABELS"
    )

    data object HeaderTwo : DrawerMenuData(
        isHeader = true,
        title = "GOOGLE APPS"
    )
}
