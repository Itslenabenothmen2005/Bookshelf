package com.example.bookshelf.data

import com.example.bookshelf.BuildConfig
import com.example.bookshelf.network.BookshelfApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Conteneur d'injection de dépendances au niveau de l'application. */
interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://www.googleapis.com/books/v1/"

    /** Le douanier : ajoute ?key=... à chaque requête sortante. */
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val url = original.url.newBuilder()
                .addQueryParameter("key", BuildConfig.BOOKS_API_KEY)
                .build()
            chain.proceed(original.newBuilder().url(url).build())
        }
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }
}