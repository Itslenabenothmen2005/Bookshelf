package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BooksResponse
import com.example.bookshelf.network.BookshelfApiService

/** Faux service : aucune requête réelle vers Google Books. */
class FakeBookshelfApiService : BookshelfApiService {

    override suspend fun searchBooks(query: String): BooksResponse {
        return FakeDataSource.searchResponse
    }

    override suspend fun getBook(id: String): Book {
        return FakeDataSource.booksList.first { it.id == id }
    }
}