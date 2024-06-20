package com.dimadyuk.gmailclone

import com.dimadyuk.gmailclone.model.Account
import com.dimadyuk.gmailclone.model.MailData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val names = listOf("John Doe", "Jane Smith", "Alice Johnson", "Bob Williams", "Charlie Brown")
val subjects = listOf("Meeting Reminder", "Project Update", "Happy Birthday!", "Important Notice", "Invitation")

val mailDataList = List(50) { index ->
    MailData(
        mailId = index,
        userName = names[index % names.size],
        subject = subjects[index % subjects.size],
        body = "This is a placeholder text for the body of the email.",
        timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"))
    )
}

val accountDataList = listOf(
    Account(
        icon = R.drawable.finger,
        userName = "Tutorials EU",
        email = "dimadyuk88@gmail.com",
        unReadMails = 99
    ),
    Account(
        userName = "Dima Morty",
        email = "chris@gmail.com",
        unReadMails = 80
    ),
    Account(
        userName = "Christy Jane",
        email = "jane@gmail.com",
        unReadMails = 99
    ),
)