package com.example.hw1_b10733040;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1_b10733040.database.TaskEntry;

import java.util.List;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private Context mContext;
    private List<TaskEntry> mTaskEntries;

    /**
     * Constructor for the TaskAdapter that initializes the Context.
     *
     * @param context  the current Context
     */
    public HistoryAdapter(Context context) {
        this.mContext = context;
    }

    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(view);
    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        // Determine the values of the wanted data
        TaskEntry taskEntry = mTaskEntries.get(position);
        String deviceName = taskEntry.getDeviceName();
        String address = taskEntry.getAddress();
        String info = taskEntry.getInfo();
        String rssi = taskEntry.getRssi();

        //Set values
        holder.deviceNameTextView.setText("裝置名稱：" + deviceName);
        holder.addressTextView.setText(address);
        holder.scanRecordTextView.setText(info);
        holder.rssiTextView.setText(rssi);
    }

    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mTaskEntries == null) {
            return 0;
        }
        return mTaskEntries.size();
    }

    public List<TaskEntry> getTasks() {
        return mTaskEntries;
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setTasks(List<TaskEntry> taskEntries) {
        mTaskEntries = taskEntries;
        notifyDataSetChanged();
    }

    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class HistoryViewHolder extends RecyclerView.ViewHolder {

        TextView deviceNameTextView;
        TextView addressTextView;
        TextView scanRecordTextView;
        TextView rssiTextView;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews
         */

        public HistoryViewHolder(View itemView) {
            super(itemView);
            deviceNameTextView = (TextView) itemView.findViewById(R.id.history_DeviceName);
            addressTextView = (TextView) itemView.findViewById(R.id.history_Address);
            scanRecordTextView = (TextView) itemView.findViewById(R.id.history_ScanRecord);
            rssiTextView = (TextView) itemView.findViewById(R.id.history_Rssi);
        }

    }
}