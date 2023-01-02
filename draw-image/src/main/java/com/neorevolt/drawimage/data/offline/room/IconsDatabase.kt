package com.neorevolt.drawimage.data.offline.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neorevolt.drawimage.data.offline.entity.IconEntity
import com.neorevolt.drawimage.data.offline.entity.LayoutEntity
import com.neorevolt.drawimage.data.offline.entity.TransactionEntity

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
@Database(entities = [IconEntity::class, LayoutEntity::class,TransactionEntity::class], version = 1, exportSchema = false)

abstract class IconsDatabase : RoomDatabase() {
    abstract fun iconsDao(): IconsDao
    abstract fun layoutDao(): LayoutDao

    companion object {
        @Volatile
        private var instance: IconsDatabase? = null

        fun getInstance(context: Context): IconsDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    IconsDatabase::class.java, "Icons.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
    }
}