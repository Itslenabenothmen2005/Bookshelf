package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookItem
import com.example.bookshelf.model.BooksResponse
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo

object FakeDataSource {

    val booksList = listOf(
        Book(
            id = "id1",
            volumeInfo = VolumeInfo(
                title = "Book One",
                imageLinks = ImageLinks(thumbnail = "http://url.one")
            )
        ),
        Book(
            id = "id2",
            volumeInfo = VolumeInfo(
                title = "Book Two",
                imageLinks = ImageLinks(thumbnail = "http://url.two")
            )
        )
    )

    val searchResponse = BooksResponse(
        items = booksList.map { BookItem(id = it.id) }
    )
}