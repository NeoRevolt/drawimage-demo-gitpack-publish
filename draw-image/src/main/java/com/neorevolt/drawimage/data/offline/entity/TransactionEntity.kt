package com.neorevolt.drawimage.data.offline.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionTb")
class TransactionEntity (

    @field:ColumnInfo("photoUrl")
    val photoUrl: String,

//    @field:ColumnInfo("createdAt")
//    val createdAt: String,

    @field:ColumnInfo("name")
    val name: String,

//    @field:ColumnInfo("description")
//    val description: String,

//    @field:ColumnInfo("lon")
//    val lon: Double? = null,

    @field:PrimaryKey(autoGenerate = true)
    @field:ColumnInfo("id")
    val id: Int? = null,

//    @field:ColumnInfo("lat")
//    var lat: Double? = null
)