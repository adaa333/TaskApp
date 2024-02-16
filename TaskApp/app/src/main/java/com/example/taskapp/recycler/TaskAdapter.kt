package com.example.taskapp.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.entities.Task
import com.example.taskapp.navigation.fragments.tasklist.TasksFragmentDirections

class TaskAdapter() : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private var taskList= emptyList<Task>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.bind(currentTask)

        //navigate to add task to update it
        val parentLinearLayout: LinearLayout = holder.itemView.parent as LinearLayout

        parentLinearLayout.setOnClickListener {
            val action = TasksFragmentDirections.actionTasksFragmentToAddTaskFragment(currentTask)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(tasks: List<Task>){
        this.taskList=tasks
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.textViewDescription)

        fun bind(task: Task) {
            titleTextView.text = task.titulo
            descriptionTextView.text = task.descripcion
        }
    }
}
