package com.example.splitthebill

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BillActivity : AppCompatActivity() {

    private val tipPercentage : Double = 0.15
    private val tipPercentageMultipler : Double = 1.15
    private var totalBill : Double = 0.00
    private var splitBill: Double = 0.00
    private var totalTipAmount: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bill_main)

        findViewById<Button>(R.id.calculateBtn)
            .setOnClickListener {
                val partySize = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
                val billAmount = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toInt()
                val totalTipView : TextView = findViewById(R.id.totalTip)
                val finalSplittedBillView : TextView = findViewById(R.id.splittedBill)

                totalBill = billAmount * tipPercentageMultipler
                splitBill = totalBill / partySize
                totalTipAmount = billAmount * tipPercentage
                totalTipView.text = totalTipAmount.toString()
                finalSplittedBillView.text = splitBill.toString()
            }

    }
}