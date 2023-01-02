package com.neorevolt.drawimage.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.neorevolt.drawimage.data.offline.entity.LayoutEntity
import com.neorevolt.drawimage.data.offline.entity.TransactionEntity
import com.neorevolt.drawimage.data.offline.room.LayoutDao

/**
 * @author [NeoRevolt](https://github.com/NeoRevolt)
 * @version 0.0.1
 * @since 7/1/2022
 */
class LayoutRepository constructor(
    private val layoutDao: LayoutDao
) {
    private val result = MediatorLiveData<Result<List<LayoutEntity>>>()

    val readAllTransactions: LiveData<List<TransactionEntity>> = layoutDao.getTransaction()
    val readAllLayout: LiveData<List<LayoutEntity>> = layoutDao.getLayout()

    suspend fun addAllTransaction(transaction: TransactionEntity) {
        layoutDao.insertTransaction(transaction)
    }

    suspend fun addAllLayout(layout: LayoutEntity) {
        layoutDao.insertLayout(layout)
    }

    fun deleteTransaction() {
        layoutDao.deleteAllTransaction()
    }

    fun deleteLayout() {
        layoutDao.deleteAllLayout()
    }
}