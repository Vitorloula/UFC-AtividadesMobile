package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Retrofitinstance
import com.example.myapplication.data.models.CreatePostRequest
import com.example.myapplication.data.models.Post
import com.example.myapplication.data.models.User
import com.example.myapplication.data.models.CreateUserRequest
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var posts: List<Post> by mutableStateOf(listOf())
    var users: List<User> by mutableStateOf(listOf())
    private val userId = 1

    fun fetchUsers(){
        viewModelScope.launch {
            try {
                users = Retrofitinstance.api.getUsers()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun fetchPosts(){
        viewModelScope.launch {
            try {
                posts = Retrofitinstance.api.getPosts(userId)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun createUser(
        name: String,
        email: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ){
        viewModelScope.launch {
            try {
                val newUser = CreateUserRequest(name, email)
                Retrofitinstance.api.createUser(newUser)
                fetchUsers()
                onSuccess()
            } catch (e: Exception){
                e.printStackTrace()
                onError()
            }
        }
    }

    fun createPost(
        title: String,
        content: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ){
        viewModelScope.launch {
            try {
                val newPost = CreatePostRequest(title, content)
                Retrofitinstance.api.createPost(userId, newPost)
                fetchPosts()
                onSuccess()
            } catch (e:Exception){
                e.printStackTrace()
                onError()
            }
        }
    }

    fun deletePost(postId: Int){
        viewModelScope.launch {
            try {
                Retrofitinstance.api.deletePost(postId)
                fetchPosts()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    fun updatePost(
        postId: Int,
        title: String,
        content: String
    ){
        viewModelScope.launch {
            try {
                val updatePost = CreatePostRequest(title, content)
                Retrofitinstance.api.updatePost(postId, updatePost)
                fetchPosts()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }


}