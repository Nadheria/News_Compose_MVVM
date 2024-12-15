package com.nadharia.quotes.repository

import com.nadharia.quotes.api.APIService
import com.nadharia.quotes.model.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class QuotesRepository @Inject constructor(private val QuotesAPI: APIService) {

    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() = _tweets

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    suspend fun getTweets(category: String) {
        val result = QuotesAPI.getTweets("tweets[?(@.category == \"$category\")]")
        if (result.isSuccessful && result.body() != null) {
            _tweets.emit(result.body()!!)

        }
    }

    suspend fun getCategories() {
        val result = QuotesAPI.getCategories()
        if (result.isSuccessful && result.body() != null) {
            _categories.emit(result.body()!!)
        }
    }
}



