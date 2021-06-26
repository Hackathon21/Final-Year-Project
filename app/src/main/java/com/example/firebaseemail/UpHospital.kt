package com.example.firebaseemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseemail.Repository.PostRepository
import com.example.firebaseemail.ViewModel.PostViewModel
import com.example.firebaseemail.ViewModel.PostViewModelFactory
import com.example.h3.UpPostAdapter.UpPostAdapter
import com.example.test.UPItem

class UpHospital : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var UPpostAdapter: UpPostAdapter
    private lateinit var postViewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_up_hospital)



        initRecyclerView()

        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getUP()
        postViewModel.UPpostMutableLiveData.observe(this, Observer {
            UPpostAdapter.setData(it as ArrayList<UPItem>)
            recyclerView.visibility= View.VISIBLE

        })
    }


    private fun initRecyclerView() {

        recyclerView = findViewById(R.id.up_recyclerView)
        UPpostAdapter= UpPostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@UpHospital)
            adapter = UPpostAdapter

        }
    }


}
