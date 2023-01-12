package com.example.todo

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(var context : Context) : SQLiteOpenHelper(context,"mydb",null, VERSION_NO) {

    companion object{
        var ID = "id"
        var VERSION_NO = 1
        var TABLE_NAME = "todo"
        var TASK = "task"
        var DATE = "date"
        var TIME = "time"
        var REPEAT = "repeat"
        var LIST = "list"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val create_db = " CREATE TABLE " + TABLE_NAME + " ( " + ID + " integer primary key AUTOINCREMENT , "+ TASK +" VARCAR(20), "+ DATE +" VARCAR(20), "+ TIME +" VARCAR(20), "+ REPEAT +" VARCAR(20), "+ LIST +" VARCAR(20) )"
        p0!!.execSQL(create_db)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(myModel: MyModel) : Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(TASK,myModel.user_task)
        contentValues.put(DATE,myModel.user_date)
        contentValues.put(TIME,myModel.user_time)
        contentValues.put(REPEAT,myModel.repeat)
        contentValues.put(LIST,myModel.user_list)

        val insertdata = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return insertdata
    }

    @SuppressLint("Range")
    fun getAll_Data() : MutableList<MyModel>{
        val userlist : MutableList<MyModel> = ArrayList()
        val sel_query = "SELECT * FROM $TABLE_NAME"
        val myDatabase = this.readableDatabase
        val cursor : Cursor?
        try {
            cursor = myDatabase.rawQuery(sel_query,null)
        }catch (e:SQLiteException){
            myDatabase.execSQL(sel_query)
            return userlist
        }
        var id : Int
        var task : String
        var date : String
        var time : String
        var repeat : String
        var list : String

        if(cursor.count > 0){
            if (cursor.moveToFirst()){
                do {
                    id = cursor.getInt(cursor.getColumnIndex("$ID"))
                    task = cursor.getString(cursor.getColumnIndex(TASK))
                    date = cursor.getString(cursor.getColumnIndex(DATE))
                    time = cursor.getString(cursor.getColumnIndex(TIME))
                    repeat = cursor.getString(cursor.getColumnIndex(REPEAT))
                    list = cursor.getString(cursor.getColumnIndex(LIST))

                    val user_data = MyModel(id,task,date,time,repeat,list)
                    userlist.add(user_data)

                }while (cursor.moveToNext())
            }
        }
        return userlist
    }

    fun update_data(myModel: MyModel) : Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(TASK,myModel.user_task)
        contentValues.put(DATE,myModel.user_date)
        contentValues.put(TIME,myModel.user_time)
        contentValues.put(REPEAT,myModel.repeat)
        contentValues.put(LIST,myModel.user_list)

        val id = db.update(TABLE_NAME,contentValues, ID+" = "+myModel.user_id,null)
        db.close()

        return id
    }

    fun delete_data(myModel: MyModel) : Int{
        val db = this.writableDatabase
        val delete_query = db.delete(TABLE_NAME, ID+" = "+myModel.user_id,null)
        db.close()

        return delete_query
    }
}