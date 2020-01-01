package com.example.acticity_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val buttonForBirthDate = findViewById<Button>(R.id.buttonSelectDate)
        buttonForBirthDate.setOnClickListener {
            val picker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, test_year, test_month, test_dayOfMonth ->
                ddmmyyyy.setText("" + test_dayOfMonth + "/" + (test_month + 1) + "/" + test_year)
                year = test_year
                (calculate(test_year))}, year, month, day)
                picker.show()
        }
    }

    private fun calculate(year: Int)
    {
        val age = Year.now().value - year
        var saving = 0
        val decimal = DecimalFormat("00.00")

        if(age in 16..20)
        {
            saving = 5000
        }
        else if(age in 21..25)
        {
            saving = 14000
        }
        else if(age in 26..30)
        {
            saving = 29000
        }
        else if(age in 31..35)
        {
            saving = 50000
        }
        else if(age in 36..40)
        {
            saving = 78000
        }
        else if(age in 41..45)
        {
            saving = 116000
        }
        else if(age in 46..50)
        {
            saving = 165000
        }
        else if(age in 51..55)
        {
            saving = 228000
        }
        else
        {
            saving = 0
        }

        val transfer = saving * 0.30

        viewAge.text = "" + age
        viewSaving.text = "RM " + saving
        viewTransfer.text = "RM " + decimal.format(transfer)
    }
}