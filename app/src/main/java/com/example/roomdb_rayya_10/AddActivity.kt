package com.example.roomdb_rayya_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdb_rayya_10.room.Series
import com.example.roomdb_rayya_10.room.SeriesDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    val db by lazy {SeriesDb(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupListener()
    }

    fun setupListener(){
        btn_save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.SeriesDao().addSeries(
                    Series(0, et_tittle.text.toString(),
                    et_description.text.toString())
                )

                finish()
            }
        }
    }
}