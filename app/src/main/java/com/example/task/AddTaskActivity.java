package com.example.task;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.task.controller.TaskController;


public class AddTaskActivity extends AppCompatActivity {

    private EditText etTaskTitle;
    private EditText etTaskDescription;
    private Button btnSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        initViews();

        btnSaveTask.setOnClickListener(v -> {
            String taskTitle = etTaskTitle.getText().toString();
            String taskDescription = etTaskDescription.getText().toString();
            saveTask(taskTitle, taskDescription);
        });
    }

    private void saveTask(String taskTitle, String taskDescription){
        TaskController taskController = new TaskController(this);
        boolean result = taskController.addTask(taskTitle, taskDescription);

        if(result){
            Toast.makeText(this,"Tarea guardada correctamente",Toast.LENGTH_SHORT).show();
            clearForm();
            showMainActivity();
        }else{
            Toast.makeText(this,"Error al guardar la tarea",Toast.LENGTH_SHORT).show();
        }
    }

    private void clearForm(){
        etTaskTitle.setText("");
        etTaskDescription.setText("");
    }

    private void showMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void initViews(){
        etTaskTitle = findViewById(R.id.etTaskTitle);
        etTaskDescription = findViewById(R.id.etTaskDescription);
        btnSaveTask = findViewById(R.id.btnSaveTask);
    }
}
