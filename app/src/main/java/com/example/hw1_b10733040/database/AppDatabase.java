package com.example.hw1_b10733040.database;


import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.hw1_b10733040.database.TaskEntry.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = com.example.hw1_b10733040.database.AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "bluetooth";
    private static com.example.hw1_b10733040.database.AppDatabase sInstance;

    public static com.example.hw1_b10733040.database.AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        com.example.hw1_b10733040.database.AppDatabase.class, com.example.hw1_b10733040.database.AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract com.example.hw1_b10733040.database.TaskDao taskDao();

}
