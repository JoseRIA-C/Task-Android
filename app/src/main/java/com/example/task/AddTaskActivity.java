package com.example.task;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task.controller.TaskController;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText title = findViewById(R.id.etTaskTitle);
        EditText desc = findViewById(R.id.etTaskDescription);
        Button save = findViewById(R.id.btnSaveTask);

        save.setOnClickListener(v -> {
            new TaskController(this)
                    .addTask(title.getText().toString(), desc.getText().toString());
            Toast.makeText(this, "Tarea guardada", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
