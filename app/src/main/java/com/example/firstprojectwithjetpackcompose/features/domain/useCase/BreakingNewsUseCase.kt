package com.example.firstprojectwithjetpackcompose.features.domain.useCase

import com.example.firstprojectwithjetpackcompose.core.Resource
import com.example.firstprojectwithjetpackcompose.features.domain.model.ArticleVo
import com.example.firstprojectwithjetpackcompose.features.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BreakingNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<Resource<List<ArticleVo>>> = flow {
        emit(Resource.Loading())
        try {
            val breakingNews = repository.getBreakingNews()
            emit(Resource.Success(breakingNews))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Oops! Something went wrong"))
        }
    }
}