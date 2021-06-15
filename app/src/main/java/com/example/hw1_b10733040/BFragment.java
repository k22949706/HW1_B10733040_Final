package com.example.hw1_b10733040;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.hw1_b10733040.database.AppDatabase;
import com.example.hw1_b10733040.database.TaskEntry;

public class BFragment extends Fragment {

    private AppDatabase mDb;
    // Constant for default task id to be used when not in update mode
    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    private static final int DEFAULT_TASK_ID = -1;
    private int mTaskId = DEFAULT_TASK_ID;
    private static final String TAG = "BFragment";
    private String message;
    private String message2;
    private String message3;
    private String message4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments() != null) {
            TextView argTextDeviceName = getView().findViewById(R.id.argText_DeviceName);
            TextView argTextRssi = getView().findViewById(R.id.argText_Rssi);
            TextView argTextAddress = getView().findViewById(R.id.argText_Address);
            TextView argTextScanRecord = getView().findViewById(R.id.argText_ScanRecord);
            BFragmentArgs args = BFragmentArgs.fromBundle(getArguments());
            message = args.getMessage();
            message2 = args.getMessage2();
            message3 = args.getMessage3();
            message4 = args.getMessage4();
            argTextDeviceName.setText(message);
            argTextRssi.setText(message2);
            argTextAddress.setText(message3);
            argTextScanRecord.setText(message4);
        }

        final NavController navController = Navigation.findNavController(view);
        Button buttonBack = view.findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_BFragment_to_AFragment);
            }
        });

        mDb = AppDatabase.getInstance(getActivity().getApplicationContext());
        Button buttonSave = view.findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToHistorylist();
                Toast.makeText(getActivity(), "儲存成功！", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * This method is called when user clicks on the Add to waitlist button
     *
     * @param view The calling view (button)
     */
    public void addToHistorylist() {
        String deviceName = message;
        String rssi = message2;
        String address = message3;
        String scanRecord = message4;

        final TaskEntry task = new TaskEntry(deviceName, address, scanRecord, rssi);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                // insert the task only if mTaskId matches DEFAULT_TASK_ID
                // Otherwise update it
                // call finish in any case
                if (mTaskId == DEFAULT_TASK_ID) {
                    // insert new task
                    mDb.taskDao().insertTask(task);
                }
                getActivity().finish();
            }
        });
    }
}