package com.example.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNormalNotification,btnFoldingNotification,btnHangingNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNormalNotification=findViewById(R.id.btn_normalNotification);
        btnFoldingNotification=findViewById(R.id.btn_foldingNotification);
        btnHangingNotification=findViewById(R.id.btn_hangingNotification);
        btnHangingNotification.setOnClickListener(this);
        btnFoldingNotification.setOnClickListener(this);
        btnNormalNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_foldingNotification) {
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.item_notification);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Notification.Builder builder = new Notification.Builder(this);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            builder.setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("测试标题")
                    .setContentText("普通通知");;
            Notification notification = builder.build();
//            notification.contentView = remoteViews;
            notification.bigContentView=remoteViews;
            notificationManager.notify((int) (Math.random() * 10), notification);
        } else if (view.getId() == R.id.btn_normalNotification) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Notification.Builder builder = new Notification.Builder(this);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            builder.setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("测试标题")
                    .setContentText("普通通知");
            Notification notification = builder.build();
            notificationManager.notify((int) (Math.random() * 10), notification);
        }else if(view.getId() == R.id.btn_hangingNotification){
//            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            Intent hangIntent=new Intent();
//            hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            hangIntent.setClass(this,MainActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
//            Notification.Builder builder = new Notification.Builder(this);
//            builder.setContentIntent(pendingIntent)
//                    .setAutoCancel(true)
//                    .setSmallIcon(R.drawable.ic_launcher_background)
//                    .setContentTitle("悬挂式通知")
//                    .setContentText("普通通知");
//
//            Notification notification = builder.build();
//            notificationManager.notify((int) (Math.random() * 10), notification);
        }
    }
}