package com.example.firstprojectwithjetpackcompose.features.data.repository

import com.example.firstprojectwithjetpackcompose.features.data.apiService.NewsApiService
import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo
import com.example.firstprojectwithjetpackcompose.features.domain.repository.NewsRepository
import com.example.firstprojectwithjetpackcompose.features.mapper.toArticleVo
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApiService
): NewsRepository {
    override suspend fun getBreakingNews(): List<ArticleVo> {
        val response = api.getBreakingNews()
        if(response.isSuccessful) {
            val newsResponse = response.body()
            if(newsResponse != null && newsResponse.articles != null) {
                return newsResponse.articles.filterNotNull().map {
                    it.toArticleVo()
                }
            }
        }

        return emptyList()
    }
}