package com.dimadyuk.gmailclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.dimadyuk.gmailclone.R
import com.dimadyuk.gmailclone.accountDataList
import com.dimadyuk.gmailclone.model.Account

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = {
            openDialog.value = false
        },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
    ) {
        AccountsDialogUI(
            modifier = Modifier
                .fillMaxWidth(),
            openDialog = openDialog
        )
    }
}

@Composable
fun AccountsDialogUI(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean> = mutableStateOf(false)
) {
    Card {
        Column(
            modifier = modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            TopContentRow(openDialog)
            AccountItem(account = accountDataList[0])
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {

                    },
                    colors = buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    border = BorderStroke(1.dp, Color.Gray)
                ) {
                    Text(text = "Google Account", textAlign = TextAlign.Center, color = Color.Black)
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            HorizontalDivider()
            accountDataList.forEachIndexed { index, account ->
                if (index > 0) {
                    AccountItem(account = account)
                }
            }
            AddAccount(icon = Icons.Outlined.PersonAddAlt, title = "Add Another Account")
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Accounts on this device")
            HorizontalDivider(Modifier.padding(vertical = 16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(5.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black
                    )
                ) { }
                Text(text = "Terms of Service")
            }
        }
    }
}

@Composable
fun AccountItem(
    account: Account
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 16.dp),
    ) {
        if (account.icon != null) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent)
                    .clip(CircleShape)
                    .clickable {
                    },
                painter = painterResource(id = R.drawable.finger),
                contentDescription = null
            )
        } else {
            IconWithFirstLetter(
                userName = account.userName,
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(text = account.userName, fontWeight = FontWeight.SemiBold)
            Text(text = account.email)
        }
        Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 8.dp))
    }
}

@Composable
private fun TopContentRow(openDialog: MutableState<Boolean>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            openDialog.value = false
        }) {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = null
            )
        }
        Image(
            modifier = Modifier
                .size(30.dp)
                .weight(1f),
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = "Google",
        )
    }
}

@Composable
fun AddAccount(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 16.dp),
    ) {
        Image(
            modifier = Modifier
                .size(24.dp)
                .background(Color.Transparent)
                .clip(CircleShape)
                .clickable {
                },
            imageVector = icon,
            contentDescription = null
        )
        Text(text = title, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview(modifier: Modifier = Modifier) {
    AccountsDialogUI(modifier = modifier)
}
