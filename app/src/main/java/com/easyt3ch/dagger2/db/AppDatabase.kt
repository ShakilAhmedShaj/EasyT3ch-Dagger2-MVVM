package com.easyt3ch.dagger2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.easyt3ch.dagger2.db.dao.HomeVideoDao
import com.easyt3ch.dagger2.domain.model.Post


@Database(
    entities = [Post::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun homeVideoDao(): HomeVideoDao


    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }

        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "EasyTech-Dagger2.db"
            ).build()

    }
}