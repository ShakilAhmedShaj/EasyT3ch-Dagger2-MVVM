package com.easyt3ch.hilt.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyt3ch.hilt.domain.model.Post

/**
 * Created by Shakil Ahmed Shaj on 09,April,2022.
 */

@Dao
interface HomeVideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReplacePosts(sources: List<Post>)

    @Query("SELECT * FROM post")
    fun getPosts(): LiveData<List<Post>>

}