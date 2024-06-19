package com.dimadyuk.gmailclone.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dimadyuk.gmailclone.mailDataList
import com.dimadyuk.gmailclone.model.MailData

@Composable
fun MailList(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    scrollState: LazyListState
) {
    Box(
        modifier = Modifier.padding(paddingValues)
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(mailDataList.size) { item ->
                MailItem(mailData = mailDataList[item])
            }
        }
    }
}

@Composable
fun MailItem(
    mailData: MailData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
            colors = CardDefaults.cardColors(
                containerColor = Color.Gray
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = mailData.userName[0].uppercase(),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(8.dp),
                )
            }
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = mailData.userName,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = mailData.subject,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = mailData.body,
                style = MaterialTheme.typography.bodySmall
            )

        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = mailData.timeStamp,
                style = MaterialTheme.typography.bodySmall
            )
            IconButton(
                modifier = Modifier
                    .size(25.dp),
                onClick = {

                }) {
                Icon(
                    imageVector = Icons.Outlined.StarOutline,
                    contentDescription = null
                )
            }
        }
    }
    HorizontalDivider()
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview(modifier: Modifier = Modifier) {
    MailItem(
        mailData = MailData(
            mailId = 0,
            userName = "John Doe",
            subject = "Hello",
            body = "Hello, how are you?",
            timeStamp = "10:00 AM"
        ),
        modifier = modifier
    )
}
