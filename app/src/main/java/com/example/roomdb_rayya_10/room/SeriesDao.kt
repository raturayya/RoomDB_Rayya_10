package com.example.roomdb_rayya_10.room

import androidx.room.*

@Dao
interface SeriesDao {

    @Insert
    suspend fun addSeries(series: Series)

    @Update
    suspend fun updateSeries(series: Series)

    @Delete
    suspend fun deleteSeries(series: Series)

    @Query ("SELECT * FROM series")
    suspend fun getSeries():List<Series>

}