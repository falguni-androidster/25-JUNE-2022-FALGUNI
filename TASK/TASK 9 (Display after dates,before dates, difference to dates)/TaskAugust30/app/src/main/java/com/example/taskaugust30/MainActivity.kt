package com.example.taskaugust30

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var tvafterdate : TextView
    lateinit var tvbeforedate : TextView
    lateinit var tvdate1 : TextView
    lateinit var tvdate2 : TextView
    lateinit var btndifference : AppCompatButton

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvafterdate = findViewById(R.id.tv_after_date)
        tvbeforedate = findViewById(R.id.tv_before_date)
        tvdate1 = findViewById(R.id.tv_difference_date1)
        tvdate2 = findViewById(R.id.tv_difference_date2)
        btndifference = findViewById(R.id.btn_difference)

        var calendar = Calendar.getInstance()

        tvafterdate.setOnClickListener {
            var dpdialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    var m = i2 + 1
                    val date = "$i3/$m/$i"
                    tvafterdate.text = date
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            dpdialog.datePicker.minDate = calendar.timeInMillis
            calendar.add(Calendar.YEAR, 0)
            dpdialog.show()
        }

        tvbeforedate.setOnClickListener {
            var dpdialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    var m = i2 + 1
                    val date = "$i3/$m/$i"
                    tvbeforedate.text = date
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            calendar.add(Calendar.YEAR, 0)
            dpdialog.datePicker.maxDate = calendar.timeInMillis
            dpdialog.show()
        }

        tvdate1.setOnClickListener {
            var dpdialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    var m = i2 + 1
                    val date = "$i3/$m/$i"
                    tvdate1.text = date
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            dpdialog.show()
        }

        tvdate2.setOnClickListener {
            var dpdialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    var m = i2 + 1
                    val date = "$i3/$m/$i"
                    tvdate2.text = date
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            dpdialog.show()
        }

        btndifference.setOnClickListener {
            var date1 = tvdate1.text.toString()
            var date2 = tvdate2.text.toString()

            var sdf = SimpleDateFormat("dd/MM/yyyy")
            var sdfdate1 = sdf.parse(date1)
            var sdfdate2 = sdf.parse(date2)

            var differencedate = Math.abs(sdfdate1.time - sdfdate2.time)
            var longdates = differencedate / (24 * 60 * 60 * 1000)
            var difference = longdates.toString()
            btndifference.text = "$difference Days"

        }
    }
}