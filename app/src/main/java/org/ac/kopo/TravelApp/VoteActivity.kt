package kr.ac.kopo.TravelApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class VoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)

        var voteCount = IntArray(4)

        for(i in 0..3)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(4)

        var imageId = arrayOf(R.id.img01, R.id.img02, R.id.img03, R.id.img04)

        var imgName = arrayOf("영국", "일본", "핀란드", "호주")

        for(i in imageId.indices){
//            ImageView객체의 참조값을 배열에 저장
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + ": 총 "+ voteCount[i] +"표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnDone = findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            var intent = Intent(applicationContext, VoteResultActivity::class.java)
            intent.putExtra("imgName", imgName)
            intent.putExtra("voteCount", voteCount)
            startActivity(intent)
        }
    }
}