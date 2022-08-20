package com.windblowing.selectroad2.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.windblowing.selectroad2.R
import com.windblowing.selectroad2.data.Message
import com.windblowing.selectroad2.utils.Constants.RECEIVE_ID
import com.windblowing.selectroad2.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.message_item.view.*


class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messageList = mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                messageList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messageList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                holder.itemView.tv_message.apply {
                    text = currentMessage.message
                //  tv.message 나 currentMessage 같이 layout 에서 import 해오는 부분은 'kotlin-android-extensions' 사용해야 함
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
                }
                RECEIVE_ID -> {
                    holder.itemView.tv_bot_message.apply {
                        text = currentMessage.message
                        visibility = View.VISIBLE
                    }
                    holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return  messageList.size
    }


    fun insertMessage(message: Message) {
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
    }
}