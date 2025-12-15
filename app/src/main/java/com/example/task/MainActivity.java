package com.example.task;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.controller.TaskController;
import com.example.task.model.Task;
import com.example.task.view.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TaskController controller;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new TaskController(this);
        adapter = new TaskAdapter();

        RecyclerView rv = findViewById(R.id.rvTasks);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        adapter.setOnTaskActionListener(new TaskAdapter.OnTaskActionListener() {
            @Override
            public void onEdit(Task task) {
                Intent i = new Intent(MainActivity.this, EditTaskActivity.class);
                i.putExtra("task_id", task.id);
                startActivity(i);
            }

            @Override
            public void onDelete(Task task) {
                controller.deleteTask(task);
                loadTasks();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fabAddTask);
        fab.setOnClickListener(v ->
                startActivity(new Intent(this, AddTaskActivity.class))
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTasks();
    }

    private void loadTasks() {
        List<Task> tasks = controller.getAllTasks();
        adapter.setData(tasks);
    }
}
