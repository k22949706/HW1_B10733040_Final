package com.example.hw1_b10733040.database;


import androidx.room.*;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM history ORDER BY deviceName")
    List<com.example.hw1_b10733040.database.TaskEntry> loadAllTasks();

    @Insert
    void insertTask(com.example.hw1_b10733040.database.TaskEntry taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(com.example.hw1_b10733040.database.TaskEntry taskEntry);

    @Delete
    void deleteTask(com.example.hw1_b10733040.database.TaskEntry taskEntry);

    // COMPLETED (1) Create a Query method named loadTaskById that receives an int id and returns a TaskEntry Object
    // The query for this method should get all the data for that id in the task table
    @Query("SELECT * FROM history WHERE id = :id")
    com.example.hw1_b10733040.database.TaskEntry loadTaskById(int id);
}
