package com.nadharia.quotes.api

import com.nadharia.quotes.model.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface APIService {

    @GET("/v3/b/67484e01ad19ca34f8d1ee5c?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<Tweet>>

    @GET("/v3/b/67484e01ad19ca34f8d1ee5c?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>




}