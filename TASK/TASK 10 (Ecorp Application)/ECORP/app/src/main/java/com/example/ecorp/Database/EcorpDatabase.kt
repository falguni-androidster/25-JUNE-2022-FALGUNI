package com.example.ecorp.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.ecorp.Model.ModelClass

class EcorpDatabase(context : Context) : SQLiteOpenHelper(context,"mydb",null, VERSION_NO) {

    companion object{
        var ID = "id"
        var VERSION_NO = 1
        var TABLE_NAME = "ecorp"
        var FIRSTNAME = "firstname"
        var LASTNAME = "lastname"
        var EMAIL = "email"
        var PASSWORD = "password"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val create_db = " CREATE TABLE " + TABLE_NAME + " ( " + ID + " integer primary key AUTOINCREMENT , "+ FIRSTNAME +" VARCAR(20), "+ LASTNAME +" VARCAR(20), "+ EMAIL +" VARCAR(20), "+ PASSWORD +" VARCAR(20) )"
        p0!!.execSQL(create_db)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(modelClass: ModelClass) : Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(FIRSTNAME,modelClass.firstname)
        contentValues.put(LASTNAME,modelClass.lastname)
        contentValues.put(EMAIL,modelClass.email)
        contentValues.put(PASSWORD,modelClass.password)

        val insertdata = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return insertdata
    }

    @SuppressLint("Range")
    fun getalldata() : MutableList<ModelClass>{
        val userlist : MutableList<ModelClass> = ArrayList()
        val sel_query = "SELECT * FROM $TABLE_NAME"
        val myDatabase = this.readableDatabase
        val cursor : Cursor?
        try {
            cursor = myDatabase.rawQuery(sel_query,null)
        }catch (e: SQLiteException){
            myDatabase.execSQL(sel_query)
            return userlist
        }
        var id : Int
        var fname : String
        var lname : String
        var email : String
        var password : String

        if(cursor.count > 0){
            if (cursor.moveToFirst()){
                do {
                    id = cursor.getInt(cursor.getColumnIndex("$ID"))
                    fname = cursor.getString(cursor.getColumnIndex(FIRSTNAME))
                    lname = cursor.getString(cursor.getColumnIndex(LASTNAME))
                    email = cursor.getString(cursor.getColumnIndex(EMAIL))
                    password = cursor.getString(cursor.getColumnIndex(PASSWORD))

                    val user_data = ModelClass(id,fname,lname,email,password)
                    userlist.add(user_data)

                }while (cursor.moveToNext())
            }
        }
        return userlist
    }

    fun update(modelClass: ModelClass) : Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(FIRSTNAME,modelClass.firstname)
        contentValues.put(LASTNAME,modelClass.lastname)
        contentValues.put(EMAIL,modelClass.email)
        contentValues.put(PASSWORD,modelClass.password)

        val id = db.update(TABLE_NAME,contentValues, ID +" = "+modelClass.id,null)
        db.close()

        return id
    }

    fun delete_data(modelClass: ModelClass) : Int{
        val db = this.writableDatabase
        val delete_query = db.delete(TABLE_NAME, ID +" = "+modelClass.id,null)
        db.close()

        return delete_query
    }
}