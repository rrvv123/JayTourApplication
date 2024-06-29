package kr.ac.kopo.TravelApp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    lateinit var mainReviewTitle: EditText
    lateinit var mainReviewContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        mainReviewTitle = findViewById(R.id.mainReviewTitle)
        mainReviewContent = findViewById(R.id.mainReviewContent)

        val homeBtn = findViewById<Button>(R.id.homeBtn)
        val checkedBtn = findViewById<Button>(R.id.checkedBtn)
        val listBtn = findViewById<Button>(R.id.listBtn)

        homeBtn.setOnClickListener {
            val intent = Intent(this@ReviewActivity, MainActivity::class.java)
            startActivity(intent)
        }

        checkedBtn.setOnClickListener {
            val title = mainReviewTitle.text.toString()
            val content = mainReviewContent.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                saveReview(title, content)
                Toast.makeText(this@ReviewActivity, "리뷰가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                mainReviewTitle.text.clear()
                mainReviewContent.text.clear()
            } else {
                Toast.makeText(this@ReviewActivity, "제목과 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        listBtn.setOnClickListener {
            val listIntent = Intent(this@ReviewActivity, ReviewListActivity::class.java)
            startActivity(listIntent)
        }
    }

    private fun saveReview(title: String, content: String) {
        val sharedPreferences = getSharedPreferences("reviews", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // 현재 리뷰 개수를 불러와 새로운 리뷰의 키로 사용
        val reviewCount = sharedPreferences.getInt("reviewCount", 0)
        editor.putString("mainReviewTitle_$reviewCount", title)
        editor.putString("mainReviewContent_$reviewCount", content)
        editor.putInt("reviewCount", reviewCount + 1)
        editor.apply()
    }
}
