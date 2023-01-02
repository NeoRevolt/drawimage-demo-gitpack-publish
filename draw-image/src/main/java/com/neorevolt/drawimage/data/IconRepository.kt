package com.neorevolt.drawimage.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.neorevolt.drawimage.data.offline.entity.IconEntity
import com.neorevolt.drawimage.data.offline.room.IconsDao

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
class IconRepository constructor(
    private val iconsDao: IconsDao,
//    private val appExecutor: AppExecutor
) {
    private val result = MediatorLiveData<Result<List<IconEntity>>>()

    val readAllIcons: LiveData<List<IconEntity>> = iconsDao.getIcons()

    suspend fun addIcons(icon: IconEntity) {
        iconsDao.insertIcon(icon)
    }

    fun deleteIcons() {
        iconsDao.deleteAll()
    }
}