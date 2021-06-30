package com.site.webbrowser

import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mywebview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         mywebview = findViewById(R.id.mywebview)

        val etUrl: EditText = findViewById(R.id.etUrl)

        val btnGo: Button = findViewById(R.id.btnGo)
        val btnfacebook: ImageView= findViewById(R.id.btnfacebook)
        val btnwhatapp: ImageView= findViewById(R.id.btnwhatapp)
        val btntwitter: ImageView= findViewById(R.id.btntwitter)
        val btnyoutube: ImageView= findViewById(R.id.btnyoutube)
        val btninstagram: ImageView= findViewById(R.id.btninstagram)

        mywebview.webViewClient = WebViewClient()

        btnGo.setOnClickListener {
            val siteUrl: String = etUrl.text.toString()

            if (URLUtil.isValidUrl(siteUrl)) {
                mywebview.loadUrl(siteUrl)
            } else {
                mywebview.loadUrl("https://www.google.com/search?q=$siteUrl")
            }
        }
        btnfacebook.setOnClickListener{
          mywebview.loadUrl("https://www.facebook.com")
        }
        btnwhatapp.setOnClickListener{
            mywebview.loadUrl("https://www.whatsapp.com")
        }
        btntwitter.setOnClickListener{
            mywebview.loadUrl("https://www.twitter.com")
        }
        btnyoutube.setOnClickListener{
            mywebview.loadUrl("https://www.youtube.com")
        }
        btninstagram.setOnClickListener{
            mywebview.loadUrl("https://www.instagram.com")
        }



            mywebview.settings.javaScriptEnabled = true

        }



    override fun onBackPressed() {
        if(mywebview.canGoBack())
        {
            mywebview.goBack()
        }
        else
        {
           super.onBackPressed()
        }

    }
}


