package com.example.kavyakanaja.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class PoemWithAuthor(
    @Embedded val poem: Poem,

    @Relation(
        parentColumn = "authorId",
        entityColumn = "id"
    )
    val author: Author
)