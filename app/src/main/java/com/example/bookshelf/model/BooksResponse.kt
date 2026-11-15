package com.example.bookshelf.model

/** Réponse de la recherche : https://www.googleapis.com/books/v1/volumes?q=... */
data class BooksResponse(
    val items: List<BookItem>? = null
)

/** Un résultat de recherche */
data class BookItem(
    val id: String
)