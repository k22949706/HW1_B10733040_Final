package com.example.hw1_b10733040;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Welcome extends AppCompatActivity {

    /** Firebase Auth */
    private static final String TAG = "Welcome";
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    public static final int RC_SIGN_IN = 1;
    private FirebaseAuth.AuthStateListener authListener = null;
    TextView mainLabel = null;
    private Button logout;

    /** Notification */
    private Button toBlueTooth;
    private Button toHistory;
    private NotificationManagerCompat notificationManagerCompat;

    /** BroadcastReceiver */
    BluetoothBroadcastReceiver bluetoothBroadcastReceiver = new BluetoothBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /** Firebase Auth */
        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mainLabel = findViewById(R.id.welcome);
        // [END initialize_auth]

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed – user is null
                    // launch login activity
                    startActivity(new Intent(Welcome.this, Login.class));
                    finish();
                }
            }
        };

        logout = (Button) findViewById(R.id.button_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        /** Notification & startActivity*/
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

    @Override
    public void onStart() {
        super.onStart();

        /** Firebase Auth */
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload(currentUser);
            mAuth.addAuthStateListener(authListener);
        } else {
            Toast.makeText(Welcome.this, "尚未登入!",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Welcome.this, SignUp.class);
            startActivity(intent);
            onResume();
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        /** BroadcastReceiver */
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(bluetoothBroadcastReceiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();

        /** BroadcastReceiver */
        unregisterReceiver(bluetoothBroadcastReceiver);
    }

    @Override
    protected void onStop() {
        super.onStop();

        /** Firebase Auth */
        if (authListener != null) {
            mAuth.removeAuthStateListener(authListener);
        }

    }

    private void reload(FirebaseUser currentUser) {
        mainLabel.setText("嗨！"+currentUser.getDisplayName());
        mainLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f);
    }

    /** Notification */
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