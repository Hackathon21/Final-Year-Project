package com.example.firebaseemail.Repository

import com.example.firebaseemail.Modal.postItem
import com.example.firebaseemail.Network.RetrofitBuilder
import com.example.test.UPItem

class PostRepository {
   // suspend fun getPost():List<postItem> = RetrofitBuilder.api.getpost()

    suspend fun getPost():List<postItem> = RetrofitBuilder.api.getpost()


    suspend fun getUP():List<UPItem> = RetrofitBuilder.api.getUP()

}