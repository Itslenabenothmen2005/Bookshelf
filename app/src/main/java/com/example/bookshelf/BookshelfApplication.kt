package com.example.bookshelf

import android.app.Application
import android.util.Log
import com.example.bookshelf.data.AppContainer
import com.example.bookshelf.data.DefaultAppContainer

class BookshelfApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        // Test temporaire : une clé Google fait 39 caractères
        Log.d("Bookshelf", "Longueur de la cle = ${BuildConfig.BOOKS_API_KEY.length}")
        container = DefaultAppContainer()
    }
}