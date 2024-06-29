package kr.ac.kopo.TravelApp

import android.content.Intent
import android.net.http.SslError
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView: WebView = findViewById(R.id.webView)
        val homeBtn: Button = findViewById(R.id.homeBtn)

        homeBtn.setOnClickListener {
            val intent = Intent(this@WebViewActivity, MainActivity::class.java)
            startActivity(intent)
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed() // SSL 인증서 오류 무시 (오류가 계속 발생하여 일시적으로 대체하였음)
            }
        }
        webView.settings.javaScriptEnabled = true

        val url = intent.getStringExtra("url")!!
        if (url != null) {
            webView.loadUrl(url)
        } else {
            // url이 null인 경우 예외 처리
            // 예를 들어, 기본 페이지를 로드하거나 사용자에게 오류 메시지를 표시할 수 있음.
            webView.loadUrl("about:blank")
        }
    }
}
