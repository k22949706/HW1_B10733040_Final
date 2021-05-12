package com.example.hw1_b10733040;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BFragment extends Fragment {

    private static final String TAG = "BFragment";

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
            String message = args.getMessage();
            String message2 = args.getMessage2();
            String message3 = args.getMessage3();
            String message4 = args.getMessage4();
            argTextDeviceName.setText(message);
            argTextRssi.setText(message2);
            argTextAddress.setText(message3);
            argTextScanRecord.setText(message4);
        }

        final NavController navController = Navigation.findNavController(view);
        Button button = view.findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_BFragment_to_AFragment);
            }
        });
    }
}