package com.example.task.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    @NonNull
    public String task_title;

    @ColumnInfo
    public String task_description;

    @ColumnInfo
    @NonNull
    public long created_at ;

    @ColumnInfo
    public boolean is_completed;

}
