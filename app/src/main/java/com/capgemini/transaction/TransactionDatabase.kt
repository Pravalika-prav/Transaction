package com.capgemini.transaction

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ Income::class,Expense::class], version = 2, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    companion object{
        private var instance: TransactionDatabase?=null
        fun getInstance(ctx: Context): TransactionDatabase {
            //bulidDB function related with viewmodel

            return instance ?: buildDB(ctx).also {
                instance = it
            }
        }
        private fun buildDB(ctx: Context): TransactionDatabase{
            return Room.databaseBuilder(ctx.applicationContext,
                TransactionDatabase::class.java,
                "finance.db").build()
        }
    }

}
