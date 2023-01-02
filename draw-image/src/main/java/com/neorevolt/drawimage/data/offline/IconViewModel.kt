package com.neorevolt.drawimage.data.offline

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.neorevolt.drawimage.data.IconRepository
import com.neorevolt.drawimage.data.offline.room.IconsDatabase
import com.neorevolt.drawimage.data.offline.entity.IconEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
class IconViewModel(application: Application): AndroidViewModel(application) {
    val readAllIcon: LiveData<List<IconEntity>>
    private val repository: IconRepository

    init {
        val iconDao = IconsDatabase.getInstance(application).iconsDao()
        repository = IconRepository(iconDao)
        readAllIcon = repository.readAllIcons
    }

    fun addIcon(icon: IconEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addIcons(icon)
        }
    }

    fun deleteIconFromDB(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteIcons()
        }
    }
}