package com.example.dataexchange.models

import android.content.Context
import android.content.Intent.getIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dataexchange.R


class PasswordAdapter internal constructor(val context: Context?, data: List<Password>) :
    RecyclerView.Adapter<PasswordAdapter.ViewHolder>() {
    private val mData: List<Password>
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.password_row_item, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val password:Password = mData[position]
        holder.passwordTextView.text = password.password
        holder.usernameTextView.text = password.username
        holder.urlTextView.text = password.url
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var urlTextView: TextView
        var usernameTextView: TextView
        var passwordTextView: TextView
        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }

        init {
            urlTextView = itemView.findViewById(R.id.tvUrl)
            usernameTextView = itemView.findViewById(R.id.tvUsername)
            passwordTextView = itemView.findViewById(R.id.tvPassword)
            itemView.setOnClickListener(this)
        }
    }

    // convenience method for getting data at click position
    fun getItem(id: Int): Password {
        return mData[id]
    }

    // allows clicks events to be caught
    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }

}