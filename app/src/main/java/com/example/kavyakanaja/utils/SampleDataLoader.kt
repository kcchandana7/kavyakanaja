package com.example.kavyakanaja.utils

import com.example.kavyakanaja.data.model.Author
import com.example.kavyakanaja.data.model.Poem

object SampleDataLoader {

    val authors = listOf(
        Author(
            id = 1,
            nameEnglish = "Kuvempu",
            nameKannada = "ಕುವೆಂಪು",
            bio = "Great Kannada poet and Jnanpith award winner.",
            era = "Modern",
            notablePoemCount = 10
        ),
        Author(
            id = 2,
            nameEnglish = "Bendre",
            nameKannada = "ಬೇಂದ್ರೆ",
            bio = "Famous Kannada poet.",
            era = "Modern",
            notablePoemCount = 8
        )
    )

    val poems = listOf(
        Poem(
            id = 1,
            titleEnglish = "Ramayana Darshanam",
            titleKannada = "ರಾಮಾಯಣ ದರ್ಶನಂ",
            content = "Epic Kannada literature masterpiece.",
            author = "Kuvempu",
            authorId = 1,
            category = "Epic",
            isFavorite = false
        ),
        Poem(
            id = 2,
            titleEnglish = "Naku Tanti",
            titleKannada = "ನಾಕು ತಂತಿ",
            content = "Philosophical poem about life.",
            author = "Bendre",
            authorId = 2,
            category = "Philosophy",
            isFavorite = false
        )
    )
}