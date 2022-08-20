package com.windblowing.selectroad2.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.windblowing.selectroad2.R
import com.windblowing.selectroad2.data.Message
import com.windblowing.selectroad2.utils.Constants.RECEIVE_ID
import com.windblowing.selectroad2.utils.Constants.SEND_ID
import com.windblowing.selectroad2.utils.BotResponse
import com.windblowing.selectroad2.utils.Constants.OPEN_GOOGLE
import com.windblowing.selectroad2.utils.Constants.OPEN_KT
import com.windblowing.selectroad2.utils.Constants.OPEN_NAVER
import com.windblowing.selectroad2.utils.Constants.OPEN_SEARCH_N
import com.windblowing.selectroad2.utils.Time
import kotlinx.android.synthetic.main.activity_sub.*
import kotlinx.coroutines.*

class SubActivity : AppCompatActivity() {
    //문제 있으면 다시 MainActivity로 변경
    private val TAG = "SubActivity"

    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessagingAdapter
    private val selectors = listOf("셀렉러즈1", "소우주", "셀렉러즈")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        recyclerview()

        clickEvents()

        val random = (0..3).random()
        customMessage("셀렉러즈와 접속 되었습니다!")
    }

    private fun clickEvents() {
        btn_send.setOnClickListener {
            sendMessage()
        }

        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }

    private fun recyclerview() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount -1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timestamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            messagesList.add(Message(message, SEND_ID, timestamp))
            et_message.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timestamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timestamp = Time.timeStamp()

        GlobalScope.launch {
            delay(500)

            withContext(Dispatchers.Main) {
                val response = BotResponse.basicResponses(message)
                messagesList.add(Message(response, RECEIVE_ID, timestamp))
                adapter.insertMessage(Message(response, RECEIVE_ID, timestamp))
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com")
                        startActivity(site)
                    }
                    OPEN_KT -> {
                        //패키지명 지정
                        val kakaopackage = "com.kakao.talk"
                        //packageManager 이용하여 'kakaopackage' 에 지정해둔 패키지명 실행
                        val intentkakao = packageManager.getLaunchIntentForPackage(kakaopackage)
                        startActivity(intentkakao)
                    }

                    OPEN_NAVER -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.naver.com")
                        startActivity(site)
                    }

                    //OPEN_SEARCH -> {
                        //val site = Intent(Intent.ACTION_VIEW)
                        //val searchTerm: String? = message.substringAfterLast("검색")
                        //site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        //startActivity(site)
                    //}

                    OPEN_SEARCH_N -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("검색")
                        site.data = Uri.parse("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=$searchTerm")
                        startActivity(site)
                    }
                }
            }
        }
    }

    private fun customMessage(message: String) {
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val timestamp = Time.timeStamp()
                adapter.insertMessage(Message(message, RECEIVE_ID, timestamp))

                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
        }
}