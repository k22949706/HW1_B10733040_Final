package com.example.hw1_b10733040;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1_b10733040.database.AppDatabase;
import com.example.hw1_b10733040.database.TaskEntry;

import java.util.List;

public class History extends AppCompatActivity {

    private RecyclerView historyRecyclerView;
    private HistoryAdapter mAdapter;
    private AppDatabase mDb;
    private final static String LOG_TAG = History.class.getSimpleName();
    // Constant for default task id to be used when not in update mode
    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    private static final int DEFAULT_TASK_ID = -1;
    private int mTaskId = DEFAULT_TASK_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Set local attributes to corresponding views
        historyRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView_HistoryList);

        // Set the layout for the RecyclerView to be a linear layout, which measures and
        // positions items within a RecyclerView into a linear list
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter and attach it to the RecyclerView
        mAdapter = new HistoryAdapter(this);
        historyRecyclerView.setAdapter(mAdapter);

        /*
         Add a touch helper to the RecyclerView to recognize when a user swipes to delete an item.
         An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
         and uses callbacks to signal when a user is performing these actions.
         */
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //do nothing, we only care about swiping
                return false;
            }

            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // Here is where you'll implement swipe to delete
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        int position = viewHolder.getAdapterPosition();
                        List<TaskEntry> tasks = mAdapter.getTasks();
                        mDb.taskDao().deleteTask(tasks.get(position));
                        retrieveTasks();
                    }
                });
            }
        }).attachToRecyclerView(historyRecyclerView);

        mDb = AppDatabase.getInstance(getApplicationContext());
    }

    /**
     * This method is called after this activity has been paused or restarted.
     * Often, this is after new data has been inserted through an AddTaskActivity,
     * so this re-queries the database data for any changes.
     */
    @Override
    protected void onResume() {
        super.onResume();
        retrieveTasks();
    }

    public void retrieveTasks() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<TaskEntry> tasks = mDb.taskDao().loadAllTasks();
                // We will be able to simplify this once we learn more
                // about Android Architecture Components
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setTasks(tasks);
                    }
                });
            }
        });
    }
}