package com.example.kavyakanaja.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kavyakanaja.data.dao.AuthorDao
import com.example.kavyakanaja.data.dao.PoemDao
import com.example.kavyakanaja.data.model.Author
import com.example.kavyakanaja.data.model.Poem

@Database(
    entities = [Poem::class, Author::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun poemDao(): PoemDao
    abstract fun authorDao(): AuthorDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "kavyakanaja_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}