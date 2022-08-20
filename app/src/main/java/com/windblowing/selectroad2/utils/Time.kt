package com.windblowing.selectroad2.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object Time {

    fun timeStamp(): String {
            val timestamp = Timestamp(System.currentTimeMillis())
            val sdf = SimpleDateFormat("HH:mm")
            val time = sdf.format(Date(timestamp.time))

            return time.toString()


        }
    }