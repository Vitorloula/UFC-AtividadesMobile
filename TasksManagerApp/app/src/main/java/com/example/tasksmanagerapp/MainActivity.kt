package com.example.tasksmanagerapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.tasksmanagerapp.ui.theme.TasksScreen
import com.example.tasksmanagerapp.viewmodel.TasksViewModel

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasksScreen(TasksViewModel(this))
        }
    }
}