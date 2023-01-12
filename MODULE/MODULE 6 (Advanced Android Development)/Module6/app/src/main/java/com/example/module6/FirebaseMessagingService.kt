package com.example.module6

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage

const val channelID = "notification_channel"
const val channelName = "com.example.module6"

class FirebaseMessagingService : com.google.firebase.messaging.FirebaseMessagingService() {

    fun getRemoteView(title:String): RemoteViews {
        var remoteView = RemoteViews(channelName,R.layout.notification_layout)
        remoteView.setTextViewText(R.id.tv_title,title)
        return remoteView
    }

    fun generateNotification(title:String){
        var intent = Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        var pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT)

        var builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext,
            channelID).setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true).setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title))

        var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var notificationChannel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (message.notification != null){
            generateNotification(message.notification!!.title!!)
        }
    }
}