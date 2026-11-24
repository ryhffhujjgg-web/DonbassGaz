package com.gas.payment

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Создаем WebView программно (без XML-разметки)
        webView = WebView(this)
        setContentView(webView)

        // Включаем JavaScript (обязательно для современных сайтов)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.setSupportZoom(true)

        // Чтобы ссылки открывались внутри WebView, а не во внешнем браузере
        webView.webViewClient = WebViewClient()

        // Загружаем ссылку
        val siteUrl = "https://donbassgaz.chmng.ru/lk/?ysclid=mq0upgwcd9792391505"
        webView.loadUrl(siteUrl)
    }

    // Обработка кнопки "Назад" на телефоне (чтобы возвращаться по истории сайта)
    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
