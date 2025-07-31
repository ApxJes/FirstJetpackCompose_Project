package com.example.firstprojectwithjetpackcompose.features.data.apiService

import com.example.firstprojectwithjetpackcompose.core.Constants.API_KEY
import com.example.firstprojectwithjetpackcompose.features.data.remote.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}