package com.example.hw1_b10733040;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 當使用者開啟或關閉網路時會進入這邊
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            // 判斷目前有無網路
            if(isNetworkAvailable(context)) {
                // 以連線至網路，做更新資料等事情
                Toast.makeText(context, "有網路!", Toast.LENGTH_SHORT).show();
            }
            else {
                // 沒有網路
                Toast.makeText(context, "沒網路!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // 回傳目前是否已連線至網路
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    };

}
