package com.example.task.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.R;
import com.example.task.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList = new ArrayList<>();
    public void setData(List<Task> tasks){
        taskList.clear();
        if (tasks != null) {
            taskList.addAll(tasks);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position){
        Task task = taskList.get(position);

        holder.task_title.setText(task.task_title);
        holder.task_description.setText(task.task_description);
        holder.task_status.setText(task.is_completed ? "Completada" : "Pendiente");

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView task_title, task_description, task_status;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            task_title = itemView.findViewById(R.id.tvTaskTitle);
            task_description = itemView.findViewById(R.id.tvTaskDescription);
            task_status = itemView.findViewById(R.id.tvTaskStatus);
        }
    }
}
