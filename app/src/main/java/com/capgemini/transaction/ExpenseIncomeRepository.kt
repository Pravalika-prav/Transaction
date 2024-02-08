package com.capgemini.transaction

import android.app.Application
import androidx.lifecycle.LiveData

class ExpenseIncomeRepository(ctx: Application) {
    val expenseIncomeDao = TransactionDatabase.getInstance(ctx).transactionDao()
   // val allExpenses: LiveData<List<Expense>> = expenseIncomeDao.getAllExpense()
    val allIncome: LiveData<List<Income>> = expenseIncomeDao.getAllIncome()
//    suspend fun insertExpense(expense: Expense) {
//        expenseIncomeDao.insertExpense(expense)
//    }
    suspend fun insertIncome(income: Income) {
        expenseIncomeDao.insertIncome(income)
    }
}
