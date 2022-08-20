package com.windblowing.selectroad2.utils

import com.windblowing.selectroad2.utils.Constants.OPEN_GOOGLE
import com.windblowing.selectroad2.utils.Constants.OPEN_KT
import com.windblowing.selectroad2.utils.Constants.OPEN_NAVER
import com.windblowing.selectroad2.utils.Constants.OPEN_SEARCH
import com.windblowing.selectroad2.utils.Constants.OPEN_SEARCH_N
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Exception
object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..3).random()
        val message = _message.toLowerCase()


        return when {
            //봇 대답 예시
            message.contains("안녕") -> {
                when (random) {
                    0 -> "안녕하세요! 저는 당신의 셀렉러즈입니다!"
                    1 -> "안녕하세요."
                    2 -> "안녕하세요!"
                    3 -> "안녕하세요, 좋은 날이네요!"
                    else -> "error"
                }
            }

            message.contains("배고파") -> {
                when (random) {
                    0 -> "배가 고프시군요..."
                    1 -> "우동 어떠세요?"
                    2 -> "돈까스가 좋겠군요"
                    3 -> "굶는 것도 좋은 방법일 수 있어요"
                    else -> "error"
                }
            }

            message.contains("내 이름이 뭐야") -> {
                when (random) {
                    0 -> "당신의 프로필 이름은 '플라밍고' 라고 합니다."
                    1 -> "안녕하세요, '플라밍고' 님!"
                    2 -> "'플라밍고' 라 지정하셨네요."
                    3 -> "비밀이랍니다."
                    else -> "error"
                }
            }

            message.contains("어지러운데 어떻게 할까?") -> {
                when (random) {
                    0 -> "맥주 한 캔 비우는 건 어떠세요?"
                    1 -> "어질어질 또 한 캔 비우세요"
                    else -> "error"
                }
            }

            message.contains("어지러운데 어떻게 하지?") -> {
                when (random) {
                    0 -> "맥주 한 캔 비우는 건 어떠세요?"
                    1 -> "어질어질 또 한 캔 비우세요"
                    else -> "error"
                }
            }

            message.contains("어지러운데 어떡하지?") -> {
                when (random) {
                    0 -> "맥주 한 캔 비우는 건 어떠세요?"
                    1 -> "어질어질 또 한 캔 비우세요"
                    else -> "error"
                }
            }

            message.contains("어지러운데 어떡할까?") -> {
                when (random) {
                    0 -> "맥주 한 캔 비우는 건 어떠세요?"
                    1 -> "어질어질 또 한 캔 비우세요"
                    else -> "error"
                }
            }

            message.contains("너 누구야") -> {
                when (random) {
                    0 -> "저는 당신의 셀렉러즈입니다"
                    1 -> "저는 당신의 셀렉러즈입니다!"
                    else -> "error"
                }
            }

            message.contains("너 누구야?") -> {
                when (random) {
                    0 -> "저는 당신의 셀렉러즈입니다"
                    1 -> "저는 당신의 셀렉러즈입니다!"
                    else -> "error"
                }
            }

            message.contains("누구세요") -> {
                when (random) {
                    0 -> "저는 당신의 셀렉러즈입니다"
                    1 -> "저는 당신의 셀렉러즈입니다!"
                    else -> "error"
                }
            }

            message.contains("누구세요?") -> {
                when (random) {
                    0 -> "저는 당신의 셀렉러즈입니다"
                    1 -> "저는 당신의 셀렉러즈입니다!"
                    else -> "error"
                }
            }

            message.contains("사랑해") -> {
                when (random) {
                    0 -> "대답할 수 없어요"
                    1 -> "대답할 수 없는 질문입니다."
                    2 -> "꿈 깨세요."
                    3 -> "밖을 나가 사회활동을 해보세요."
                    else -> "error"
                }
            }

            message.contains("구글") && message.contains("구글 켜줘") -> {
                OPEN_GOOGLE
            }

            message.contains("네이버") && message.contains("네이버 켜줘") -> {
                OPEN_NAVER
            }

            message.contains("카카오톡") && message.contains("카카오톡 켜줘") -> {
                OPEN_KT
            }

            message.contains("시간") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm 입니다")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            message.contains("검색")-> {
                OPEN_SEARCH_N
            }

            message.contains("몇 시") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm 입니다")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //질문이 항목에 없을 때
            else -> {
                when (random) {
                    0 -> "다시 입력해주세요!"
                    1 -> "대답 할 수 없는 질문이네요"
                    2 -> "접속이 종료되었습니다"
                    3 -> "네트워크 연결상태가 좋지 않습니다. 잠시 후 다시 시도해주세요."
                    else -> "error"
                }
            }
        }
    }
}