package com.enriqif.domain.use_case

import com.enriqif.domain.common.Resource
import com.enriqif.domain.model.Notebook
import com.enriqif.domain.repository.NotebookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetNotebooksUseCase @Inject constructor(
    private val repository: NotebookRepository
) {
    operator  fun invoke(): Flow<Resource<List<Notebook>>> = flow {
        emit(Resource.Loading())
        try {
            val notebooks = repository.getNotebooks()
            emit(Resource.Success(notebooks))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error Check your internet connection"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}