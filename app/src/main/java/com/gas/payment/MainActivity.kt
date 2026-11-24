package com.gas.payment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Ссылка на личный кабинет Донбассгаз
        val siteUrl = "https://donbassgaz.chmng.ru/lk/?ysclid=mq0upgwcd9792391505" 
        
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(siteUrl))
            startActivity(intent)
        } catch (e: Exception) {
            // Если браузера нет, приложение просто закроется
        }
        
        finish()
    }
}
