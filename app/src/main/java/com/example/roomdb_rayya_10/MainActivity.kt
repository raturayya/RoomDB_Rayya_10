package com.example.roomdb_rayya_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdb_rayya_10.room.Series
import com.example.roomdb_rayya_10.room.SeriesDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val db by lazy { SeriesDb(this) }
    lateinit var seriesAdapter: SeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
        setupRecyclerView()

    }

    override fun onStart(){
        super.onStart()
        CoroutineScope(Dispatchers.Default).launch {
            val series = db.SeriesDao().getSeries()
            Log.d("MainActivity", "dbresponse: $series")
            withContext(Dispatchers.Main){
                seriesAdapter.setData(series)
            }

        }
    }

    fun setupListener(){
        add_series.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    private fun setupRecyclerView(){
        seriesAdapter = SeriesAdapter(arrayListOf())
        rv_series.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = seriesAdapter
        }
    }
}