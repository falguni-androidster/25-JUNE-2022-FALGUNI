package com.example.todo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class DataAdapter(var context: Context, var userlist: MutableList<MyModel>, var tvnothing: TextView): RecyclerView.Adapter<DataAdapter.DataClass>() {

    var isEnable = false
    var isSelectAll = false
    var selectList: ArrayList<MyModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataClass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.raw_layout,parent,false)
        return DataClass(view)
    }

    override fun onBindViewHolder(holder: DataClass, position: Int) {
        var viewholder = userlist[position]
        holder.task.text = viewholder.user_task
        holder.date.text = viewholder.user_date
        holder.time.text = viewholder.user_time
        if (viewholder.repeat == "No repeat") {
            holder.repeat.visibility = View.GONE
        } else {
            holder.repeat.visibility = View.VISIBLE
        }
        holder.list.text = viewholder.user_list

        // check condition
        if(isSelectAll) {
            holder.checkbox.visibility = View.VISIBLE
        } else {
            holder.checkbox.visibility = View.GONE
        }

        holder.itemView.setOnLongClickListener { v ->
            if (!isEnable) {
                val callback: ActionMode.Callback = object : ActionMode.Callback {
                    override fun onCreateActionMode(mode: ActionMode, menu: Menu?): Boolean {
                        val menuInflater: MenuInflater = mode.menuInflater
                        menuInflater.inflate(R.menu.menu_multi_select, menu)
                        return true
                    }

                    override fun onPrepareActionMode(mode: ActionMode, menu: Menu?): Boolean {
                        isEnable = true
                        ClickItem(holder)
                        return true
                    }

                    override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                        when (item.itemId) {
                            R.id.menu_delete -> {
                                for (s in selectList) {
                                    val db = MyDatabase(context)
                                    val myModel = MyModel(viewholder.user_id, viewholder.user_task, viewholder.user_date, viewholder.user_time, viewholder.repeat,viewholder.user_list)
                                    db.delete_data(myModel)
                                    userlist.remove(s)
                                }
                                if (userlist.size == 0) {
                                    tvnothing.visibility = View.VISIBLE
                                }
                                mode.finish()
                            }
                            R.id.menu_select_all -> {
                                if (selectList.size == userlist.size) {
                                    isSelectAll = false
                                    selectList.clear()
                                } else {
                                    isSelectAll = true
                                    selectList.clear()
                                    selectList.addAll(userlist)
                                }
                                notifyDataSetChanged()
                            }
                        }
                        return true
                    }

                    override fun onDestroyActionMode(mode: ActionMode?) {
                        isEnable = false
                        isSelectAll = false
                        selectList.clear()
                        notifyDataSetChanged()
                    }
                }
                (v.context as AppCompatActivity).startActionMode(callback)
            } else {
                ClickItem(holder)
            }
            true
        }

        holder.itemView.setOnClickListener {
            if (isEnable) {
                ClickItem(holder)
            } else {
                var intent = Intent(context,AddtaskActivity :: class.java)
                intent.putExtra("update",false)
                intent.putExtra("id",viewholder.user_id)
                intent.putExtra("task",viewholder.user_task)
                intent.putExtra("date",viewholder.user_date)
                intent.putExtra("time",viewholder.user_time)
                intent.putExtra("repeat",viewholder.repeat)
                intent.putExtra("list",viewholder.user_list)
                (context as Activity).finish()
                context.startActivity(intent)
            }
        }
    }

    private fun ClickItem(holder: DataClass) {
        val s: MyModel = userlist.get(holder.adapterPosition)
        // check condition
        if (holder.checkbox.visibility == View.GONE) {
            holder.checkbox.visibility = View.VISIBLE
            selectList.add(s)
        } else {
            holder.checkbox.visibility = View.GONE
            selectList.remove(s)
        }
    }

    override fun getItemCount(): Int {
       return userlist.size
    }

    class DataClass(view: View):RecyclerView.ViewHolder(view){
        var task = view.findViewById<TextView>(R.id.tv_addtask)
        var date = view.findViewById<TextView>(R.id.tv_date)
        var time = view.findViewById<TextView>(R.id.tv_time)
        var repeat = view.findViewById<ImageView>(R.id.iv_repeat)
        var list = view.findViewById<TextView>(R.id.tv_list)
        var checkbox = view.findViewById<ImageView>(R.id.iv_check_box)
    }
}