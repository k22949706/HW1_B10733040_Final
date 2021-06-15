package com.example.hw1_b10733040;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification extends Application {
    public static final String CHANNEL_ID = "channel";
    public static final String CHANNEL2_ID = "history";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                  CHANNEL_ID,
                    "Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel.setDescription("Bluetooth Notification");

            NotificationChannel notificationChannel2 = new NotificationChannel(
                    CHANNEL2_ID,
                    "History",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel2.setDescription("History Notification");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
            manager.createNotificationChannel(notificationChannel2);
        }
    }
}
