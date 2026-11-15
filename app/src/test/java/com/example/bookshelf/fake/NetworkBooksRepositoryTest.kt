package com.example.bookshelf

import com.example.bookshelf.data.NetworkBooksRepository
import com.example.bookshelf.fake.FakeBookshelfApiService
import com.example.bookshelf.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBooksRepositoryTest {

    @Test
    fun networkBooksRepository_getBooks_verifyBooksList() = runTest {
        val repository = NetworkBooksRepository(
            apiService = FakeBookshelfApiService()
        )
        assertEquals(FakeDataSource.booksList, repository.getBooks("jazz"))
    }
}