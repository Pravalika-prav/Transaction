package com.capgemini.transaction

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExpense(expense: Expense)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIncome(income: Income)

    @Query("select * from Expense where email=:mail")
    fun getAllExpense(mail:String):LiveData<List<Expense>>

    @Query("select * from Income")
    fun getAllIncome():LiveData<List<Income>>

}