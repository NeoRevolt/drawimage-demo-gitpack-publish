package com.neorevolt.drawimage.data.offline.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
@Entity(tableName = "iconTb")
class IconEntity(

    @field:ColumnInfo(name = "iconId")
    @field:PrimaryKey(autoGenerate = true)
    val iconId: Int? = null,

    @field:ColumnInfo(name = "iconName")
    val iconName: String,

    @field:ColumnInfo(name = "iconUrl")
    val iconUrl: String
)