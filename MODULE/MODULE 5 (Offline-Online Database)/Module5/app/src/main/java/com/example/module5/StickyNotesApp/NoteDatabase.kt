package com.example.module5.StickyNotesApp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class NoteDatabase(var context : Context) : SQLiteOpenHelper(context,"mydbnote",null, VERSION_NO) {

    companion object{
        var ID = "id"
        var VERSION_NO = 1
        var TABLE_NAME = "notes"
        var NOTE = "note"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val create_db =
            " CREATE TABLE $TABLE_NAME ( $ID integer primary key AUTOINCREMENT , $NOTE VARCAR(20) )"
        p0!!.execSQL(create_db)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(myModel: NoteModel) : Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(NOTE,myModel.user_note)

        val insertdata = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return insertdata
    }

    @SuppressLint("Range")
    fun getAll_Data() : MutableList<NoteModel>{
        val userlist : MutableList<NoteModel> = ArrayList()
        val select_query = "SELECT * FROM $TABLE_NAME"
        val myDatabase = this.readableDatabase
        val cursor : Cursor?
        try {
            cursor = myDatabase.rawQuery(select_query,null)
        }catch (e: SQLiteException){
            myDatabase.execSQL(select_query)
            return userlist
        }
        var id : Int
        var note : String

        if(cursor.count > 0){
            if (cursor.moveToFirst()){
                do {
                    id = cursor.getInt(cursor.getColumnIndex(ID))
                    note = cursor.getString(cursor.getColumnIndex(NOTE))
                    val user_data = NoteModel(id,note)
                    userlist.add(user_data)
                }while (cursor.moveToNext())
            }
        }
        return userlist
    }

    fun update_data(myModel: NoteModel) : Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(NOTE,myModel.user_note)

        val id = db.update(TABLE_NAME,contentValues, ID+" = "+myModel.user_id,null)
        db.close()

        return id
    }

    fun delete_data(myModel: NoteModel) : Int{
        val db = this.writableDatabase
        val delete_query = db.delete(TABLE_NAME, ID+" = "+myModel.user_id,null)
        db.close()

        return delete_query
    }
}