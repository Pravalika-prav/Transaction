package com.capgemini.transaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add the expenseIncomeEntryy():fragment

        val frag=ExpenseIncomeEntryyy()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.containerF,frag)

        transaction.commit()
    }
}