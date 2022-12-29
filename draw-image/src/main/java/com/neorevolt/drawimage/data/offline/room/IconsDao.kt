package com.neorevolt.drawimage.data.offline.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.neorevolt.drawimage.data.offline.entity.IconEntity

@Dao
interface IconsDao {

    @Query("SELECT * FROM iconTb ORDER BY iconName ASC")
    fun getIcons(): LiveData<List<IconEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIcon(icon: IconEntity)

    @Update
    fun updateIcons(icon: IconEntity)

    @Query("DELETE FROM iconTb")
    fun deleteAll()
}