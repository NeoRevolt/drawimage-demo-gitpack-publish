package com.neorevolt.drawimage.data.offline.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
@Entity(tableName = "transactionTb")
class TransactionEntity (

    @field:ColumnInfo("photoUrl")
    val photoUrl: String,

    @field:ColumnInfo("name")
    val name: String,

    @field:PrimaryKey(autoGenerate = true)
    @field:ColumnInfo("id")
    val id: Int? = null,
)