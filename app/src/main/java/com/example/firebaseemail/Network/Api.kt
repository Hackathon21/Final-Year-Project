package com.example.firebaseemail.Network

import com.example.firebaseemail.Modal.postItem
import com.example.test.UPItem
import retrofit2.http.GET

interface Api {

//    @GET("posts")
//    suspend fun getpost():List<Posts>

    @GET("608982f703eef3de2bd05a72/Bengaluru")
    suspend fun getpost():List<postItem>

//    @GET("609fc7dde75f9ccdd696eb35/Uttar%20Pradesh")
//    suspend fun getpost():List<UPItem>


    @GET("609fc7dde75f9ccdd696eb35/Uttar%20Pradesh")
    suspend fun getUP():List<UPItem>






}