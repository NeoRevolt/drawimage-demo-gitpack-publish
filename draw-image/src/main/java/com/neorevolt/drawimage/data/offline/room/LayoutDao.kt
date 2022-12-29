package com.neorevolt.drawimage.data.offline.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.neorevolt.drawimage.data.offline.entity.LayoutEntity
import com.neorevolt.drawimage.data.offline.entity.TransactionEntity

@Dao
interface LayoutDao {
    @Query("SELECT * FROM layoutTb ORDER BY id ASC")
    fun getLayout(): LiveData<List<LayoutEntity>>

    @Query("SELECT * FROM transactionTb ORDER BY id ASC")
    fun getTransaction(): LiveData<List<TransactionEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLayout(transaction: LayoutEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Update
    fun updateLayout(layout: LayoutEntity)

    @Update
    fun updateTransaction(transaction: TransactionEntity)

    @Query("DELETE FROM layoutTb")
    fun deleteAllLayout()

    @Query("DELETE FROM transactionTb")
    fun deleteAllTransaction()
}