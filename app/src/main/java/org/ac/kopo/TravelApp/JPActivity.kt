package kr.ac.kopo.TravelApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class JPActivity : AppCompatActivity() {

    lateinit var homeBtn : Button
    lateinit var take_pointBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jp)

        // homeBtn과 take_pointBtn을 findViewById로 초기화
        homeBtn = findViewById(R.id.homeBtn)
        take_pointBtn = findViewById(R.id.take_pointBtn)

        // homeBtn 클릭 시 메인 홈으로 돌아가는 기능 구현
        homeBtn.setOnClickListener {
            val intent = Intent(this@JPActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // take_pointBtn 클릭 시 별점 매기기 화면으로 이동하는 기능 구현
        take_pointBtn.setOnClickListener {
            val intent = Intent(this@JPActivity, VoteActivity::class.java)
            startActivity(intent)
        }
    }
}
