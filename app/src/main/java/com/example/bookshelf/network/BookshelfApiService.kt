package com.example.bookshelf.network

import androidx.compose.ui.graphics.vector.Path
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookshelfApiService {

    /** Recherche de livres : volumes?q=jazz+history */
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BooksResponse

    /** Détails d'un livre : volumes/<id> */
    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): Book
}