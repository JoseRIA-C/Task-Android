package com.example.task;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.controller.TaskController;
import com.example.task.model.Task;
import com.example.task.view.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TaskAdapter taskAdapter ;
    private TaskController taskController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewBooks = findViewById(R.id.rvTasks);
        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));

        taskAdapter = new TaskAdapter();
        recyclerViewBooks.setAdapter(taskAdapter);

        taskController = new TaskController(this);
        List<Task> tasks = taskController.getAllTasks();
        taskAdapter.setData(tasks);

        FloatingActionButton fabAddBook = findViewById(R.id.fabAddTask);

        fabAddBook.setOnClickListener(view -> {
            showAddTaskActivity();
        });

    }
    private void showAddTaskActivity(){
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }
}