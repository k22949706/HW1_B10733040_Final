package com.example.hw1_b10733040;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Welcome extends AppCompatActivity {

    private Button toBlueTooth;
    private Button toHistory;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toBlueTooth = (Button) findViewById(R.id.button_BlueTooth);
        toHistory = (Button) findViewById(R.id.button_history);

        toBlueTooth.setOnClickListener(v -> {
            Context context = Welcome.this;
            Intent startActivityIntent = new Intent(context, MainActivity.class);
            startActivity(startActivityIntent);
            sendOnChannel(v);
        });

        toHistory.setOnClickListener(v -> {
            Context context = Welcome.this;
            Intent startActivityIntent = new Intent(context, History.class);
            startActivity(startActivityIntent);
            sendOnHistory(v);
        });

        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    public void sendOnChannel(View v) {
        android.app.Notification notification = new NotificationCompat.Builder(this, Notification.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_bluetooth)
                .setContentTitle("藍芽掃描裝置")
                .setContentText("按下開始掃描即可掃描藍芽裝置")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void sendOnHistory(View v) {
        android.app.Notification notification = new NotificationCompat.Builder(this, Notification.CHANNEL2_ID)
                .setSmallIcon(R.drawable.ic_bluetooth)
                .setContentTitle("已儲存的藍芽裝置")
                .setContentText("往左或往右滑可以移除裝置紀錄")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}