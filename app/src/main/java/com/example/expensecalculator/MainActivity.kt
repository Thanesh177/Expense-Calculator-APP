package com.example.expensecalculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var f:Int = 0;
    private var t:Int = 0;
    private var e:Int = 0;
    private var s:Int = 0;
    private var tt:Int = 0;
    private var r:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultTV: TextView = findViewById(R.id.output1)
        var txt1: TextView = findViewById(R.id.edtxt1)
        val button: Button = findViewById(R.id.button1)
        val add: Button = findViewById(R.id.add1)
        val resultTV2: TextView = findViewById(R.id.Saving)
        var sav1: TextView = findViewById(R.id.sav)
        var flag: String = "Food"
        val spinnerVal: Spinner = findViewById(R.id.spinner1)
        var options = arrayOf("Food", "Travel", "Entertainment")
        spinnerVal.adapter =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        add.setOnClickListener{ view ->
            val y: Int = sav1.text.toString().toInt();
            if(tt == 0){
                s += y
            }else{
                s = r + y
            }
            resultTV2.text = "Savings: $s"
        }
        button.setOnClickListener{ view ->
            var x: Int = txt1.text.toString().toInt();
            val selectedCategory = options[spinnerVal.selectedItemPosition]
            val total = when(flag) {
                "Food" -> {
                    f += x
                    f
                }

                "Travel" -> {
                    t += x
                    t
                }

                "Entertainment" -> {
                    e += x
                    e
                }

                else -> {
                    "Invalid"
                }
            }
            tt = f+t+e;
            r = s - tt;
            resultTV.text = """
            Food Expense: $f
            Travel Expense: $t
            Entertainment Expense: $e
            Overall Expense: $tt
            """.trimIndent()
            resultTV2.text = "Savings:$r"
        }
    }
}