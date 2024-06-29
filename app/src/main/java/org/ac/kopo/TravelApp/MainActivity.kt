package kr.ac.kopo.TravelApp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var ukBtn: Button
    lateinit var jpBtn: Button
    lateinit var finBtn: Button
    lateinit var ausBtn: Button
    lateinit var safeBtn: Button
    lateinit var weatherBtn: Button
    lateinit var exchangeBtn: Button
    lateinit var voteTotalBtn: Button
    lateinit var reviewBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 각 버튼을 findViewById로 찾아서 변수에 저장
        ukBtn = findViewById<Button>(R.id.ukBtn)
        jpBtn = findViewById<Button>(R.id.jpBtn)
        finBtn = findViewById<Button>(R.id.finBtn)
        ausBtn = findViewById<Button>(R.id.ausBtn)
        safeBtn = findViewById<Button>(R.id.safeBtn)
        weatherBtn = findViewById<Button>(R.id.weatherBtn)
        exchangeBtn = findViewById<Button>(R.id.exchangeBtn)
        voteTotalBtn = findViewById<Button>(R.id.voteTotalBtn)
        reviewBtn = findViewById<Button>(R.id.reviewBtn)

        // 각 버튼에 OnClickListener 설정
        ukBtn.setOnClickListener(btnListener)
        jpBtn.setOnClickListener(btnListener)
        finBtn.setOnClickListener(btnListener)
        ausBtn.setOnClickListener(btnListener)
        safeBtn.setOnClickListener(btnListener)
        weatherBtn.setOnClickListener(btnListener)
        exchangeBtn.setOnClickListener(btnListener)
        voteTotalBtn.setOnClickListener(btnListener)
        reviewBtn.setOnClickListener(btnListener)
    }

    // 공통 OnClickListener 설정
    val btnListener = View.OnClickListener {
        var url = ""

        when (it.id) {
            R.id.ukBtn -> startActivity(Intent(this@MainActivity, UKActivity::class.java))
            R.id.jpBtn -> startActivity(Intent(this@MainActivity, JPActivity::class.java))
            R.id.finBtn -> startActivity(Intent(this@MainActivity, FINActivity::class.java))
            R.id.ausBtn -> startActivity(Intent(this@MainActivity, AUSActivity::class.java))
            R.id.voteTotalBtn -> startActivity(Intent(this@MainActivity, VoteResultActivity::class.java))
            R.id.reviewBtn -> startActivity(Intent(this@MainActivity, ReviewActivity::class.java))
            R.id.safeBtn -> url = "https://www.0404.go.kr"
            R.id.weatherBtn -> url = "https://www.weather.go.kr"
            R.id.exchangeBtn -> url = "https://finance.naver.com"
        }

        if (url.isNotEmpty()) {
            val intent = Intent(this@MainActivity, WebViewActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }
    }
}
