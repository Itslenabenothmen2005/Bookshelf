package com.example.bookshelf.model

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
) {
    /** Google renvoie du http */
    val thumbnailUrl: String?
        get() = volumeInfo.imageLinks?.thumbnail?.replaceFirst("http://", "https://")
}

data class VolumeInfo(
    val title: String? = null,
    val imageLinks: ImageLinks? = null
)

data class ImageLinks(
    val thumbnail: String? = null
)