package com.cursokotlin.mvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cursokotlin.mvvm.data.database.entities.QuoteEntity
import com.cursokotlin.mvvm.data.model.QuoteModel

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inseertAll(quotes: List<QuoteEntity>)

}