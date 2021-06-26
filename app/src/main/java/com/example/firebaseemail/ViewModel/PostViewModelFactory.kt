package com.example.firebaseemail.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseemail.Repository.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }

}