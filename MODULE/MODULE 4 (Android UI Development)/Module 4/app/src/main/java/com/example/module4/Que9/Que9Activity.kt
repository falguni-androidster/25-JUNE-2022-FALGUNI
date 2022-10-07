package com.example.module4.Que9

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.example.module4.R
import kotlin.collections.ArrayList

class Que9Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que9)

        val tableLayout = findViewById<View>(R.id.tl_que9) as TableLayout

        val id : MutableList<String> = ArrayList()
        id.add(getString(R.string.id))
        id.add("1")
        id.add("2")
        id.add("3")
        id.add("4")
        id.add("5")

        val marks : MutableList<String> = ArrayList()
        marks.add(getString(R.string.marks))
        marks.add("56")
        marks.add("78")
        marks.add("94")
        marks.add("65")
        marks.add("87")

        val lang : MutableList<String> = ArrayList()
        lang.add(getString(R.string.language))
        lang.add("Android")
        lang.add("C")
        lang.add("C++")
        lang.add("Java")
        lang.add("Python")

        val tableRows = arrayOfNulls<TableRow>(id.size)
        for (i in tableRows.indices) {
            tableRows[i] = TableRow(this)
            tableRows[i]!!.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
            )
            tableRows[i]!!.weightSum = 1.0f
            var text = TextView(this)
            text.setBackgroundResource(R.drawable.bg_textview)
            text.setTextColor(Color.parseColor("#37A5D8"))
            text.setPadding(20)
            text.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f)
            text.text = id[i]
            tableRows[i]!!.addView(text)

            text = TextView(this)
            text.setTextColor(Color.parseColor("#37A5D8"))
            text.setBackgroundResource(R.drawable.bg_textview)
            text.setPadding(20)
            text.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f)
            text.text = marks[i]
            tableRows[i]!!.addView(text)

            text = TextView(this)
            text.setBackgroundResource(R.drawable.bg_textview)
            text.setTextColor(Color.parseColor("#37A5D8"))
            text.setPadding(20)
            text.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f)
            text.text = lang[i]
            tableRows[i]!!.addView(text)

            tableLayout.addView(tableRows[i])
        }
    }
}