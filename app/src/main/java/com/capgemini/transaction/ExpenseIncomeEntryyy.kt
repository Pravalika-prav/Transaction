package com.capgemini.transaction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseIncomeEntryyy: Fragment() {
    lateinit var amountEditText: EditText
    lateinit var categoryEditText: EditText
    lateinit var descriptionEditText: EditText
    lateinit var incomeB: Button
    lateinit var expenseB: Button

    var isAddedClicked = false
    //private lateinit var repository: ExpenseIncomeRepository
    lateinit var expenseIncomeVM: ExpenseIncomeViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense_income_entryyy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expenseIncomeVM = ViewModelProvider(requireActivity()).get(ExpenseIncomeViewmodel::class.java)
        amountEditText = view.findViewById(R.id.amountE)
        categoryEditText = view.findViewById(R.id.catE)
        descriptionEditText = view.findViewById(R.id.descE)
        Log.d("ExpenseIncomeentryyyy","first")


            incomeB.setOnClickListener {
                isAddedClicked = true
                Log.d("ExpenseIncomeentryyyy","second")
                val amount = amountEditText.text.toString().toDouble()
                val category = categoryEditText.text.toString()
                val description = descriptionEditText.text.toString()
                //val timestamp = System.currentTimeMillis()
                CoroutineScope(Dispatchers.Default).launch {
                val financedao = TransactionDatabase.getInstance(requireContext()).transactionDao()
                val income = Income(
                    amount = amount,
                    category = category,
                    description = description,
                    //timestamp = timestamp

                )

                expenseIncomeVM.insertIncome(income)
                CoroutineScope(Dispatchers.Main).launch{
                    if (isAddedClicked){
                        Toast.makeText(requireContext(),"income saved",Toast.LENGTH_LONG)
                    }
                    else{
                        Toast.makeText(requireContext(),"income not saved",Toast.LENGTH_LONG)
                    }
                }
            }
//            expenseB.setOnClickListener {
//                val amount = amountEditText.text.toString().toDouble()
//                val category = categoryEditText.text.toString()
//                val description = descriptionEditText.text.toString()
//                val timestamp = System.currentTimeMillis()
//                val expense = Expense(
//                    amount = amount,
//                    category = category,
//                    description = description,
//                    timestamp = timestamp
//                )
//                expenseIncomeVM.insertExpense(expense)
//
//            }
        }
        //expenseIncomeVM = ViewModelProvider(this).get(ExpenseIncomeVM::class.java)
    }
}

