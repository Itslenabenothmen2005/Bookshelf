package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookshelfApiService

/** Contrat : comment l'app obtient des livres (peu importe la source). */
interface BooksRepository {
    suspend fun getBooks(query: String): List<Book>
}

/** Implémentation réseau qui utilise le service Retrofit. */
class NetworkBooksRepository(
    private val apiService: BookshelfApiService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<Book> {
        //la recherche, pour récupérer les ids
        val ids = apiService.searchBooks(query).items.orEmpty().map { it.id }

        // requête par livre, l'une après l'autre dans la même coroutine
        val books = mutableListOf<Book>()
        for (id in ids) {
            books.add(apiService.getBook(id))
        }
        return books
    }
}