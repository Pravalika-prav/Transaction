package com.capgemini.transaction

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "Expense")
//data class Expense(
//    @PrimaryKey(autoGenerate = true)
//    val id: Long = 0,
//    val amount: Double,
//    val category: String,
//    val description: String,
//    //val timestamp: Long
//)

@Entity(tableName = "Income")
data class Income(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val category: String,
    val description: String,
    //val timestamp: Long
)
