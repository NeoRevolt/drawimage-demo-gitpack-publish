package com.neorevolt.drawimage.data.offline.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
@Entity(tableName = "layoutTb")
class LayoutEntity(

    @field:ColumnInfo("photoUrl")
    val photoUrl: String,

    @field:ColumnInfo("createdAt")
    val createdAt: String,

    @field:ColumnInfo("name")
    val name: String,

    @field:ColumnInfo("description")
    val description: String,

    @field:ColumnInfo("lon")
    val lon: Double,

    @field:PrimaryKey
    @field:ColumnInfo("id")
    val id: String,

    @field:ColumnInfo("lat")
    var lat: Double
)