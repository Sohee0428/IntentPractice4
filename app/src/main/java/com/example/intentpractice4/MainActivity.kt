package com.example.intentpractice4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(myIntent, 1004)




        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        돌아온 이유가 닉네임을 받으로 다녀온것이 맞는지 확인

        if (requestCode == REQUEST_FOR_NICKNAME) {

//            추가 질문 - 확인을 눌러서 돌아온 것이 맞는지 확인

            if (resultCode == Activity.RESULT_OK) {

//                실제로 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영

                val newNickname = data?.getStringExtra("nickname")

                nicknameTxt.text = newNickname
            }

        }
    }
}