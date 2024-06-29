package kr.ac.kopo.TravelApp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ReviewListActivity : AppCompatActivity() {

    lateinit var homeBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)

        homeBtn = findViewById(R.id.homeBtn)

        val reviewListView = findViewById<ListView>(R.id.reviewListView)
        val reviews = loadReviews()

        val adapter = ArrayAdapter(this@ReviewListActivity, android.R.layout.simple_list_item_1, reviews)
        reviewListView.adapter = adapter

        homeBtn.setOnClickListener {
            val intent = Intent(this@ReviewListActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadReviews(): List<String> {
        val sharedPreferences = getSharedPreferences("reviews", Context.MODE_PRIVATE)
        val reviewCount = sharedPreferences.getInt("reviewCount", 0)
        val reviews = mutableListOf<String>()

        for (i in 0 until reviewCount) {
            val title = sharedPreferences.getString("mainReviewTitle_$i", "제목 없음")
            val content = sharedPreferences.getString("mainReviewContent_$i", "내용 없음")
            reviews.add("제목: $title\n내용: $content")
        }

        return reviews
    }
}
