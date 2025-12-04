package com.example.task.controller;

import android.content.Context;
import android.util.Log;

import com.example.task.model.Task;
import com.example.task.model.TaskDao;
import com.example.task.model.TaskDatabase;

import java.util.List;

public class TaskController {

    private final TaskDao taskDao;

    public TaskController(Context context){
        TaskDatabase database = TaskDatabase.getInstance(context);
        taskDao = database.taskDao();
    }

    //Create Task

    public boolean addTask(String task_tile, String task_description) {
        try {
            Task task = new Task();
            task.task_title = task_tile;
            task.task_description = task_description;
            task.created_at = System.currentTimeMillis();
            task.is_completed = false;
            taskDao.insert(task);
            Log.i("TASK_SAVE","La tarea ha sido almacenada correctamente");
            return true;
        }catch (Exception e){
            Log.e("BOOK_ERROR",e.getMessage());
            return false;
        }
    }

    //Update Task
    public void updateTask(Task task) {taskDao.update(task);}

    //Delete Task
    public void deleteTask(Task task) {taskDao.delete(task);}

    //GetById
    public Task getTaskById(int id) {
        return taskDao.getTaskById(id);
    }

    //GetAll
    public List<Task> getAllTasks(){return taskDao.getAllTasks();}
}
