package com.enriqif.data.repository

import com.enriqif.data.api.NotebookApi
import com.enriqif.data.extensions.toNotebook
import com.enriqif.domain.model.Notebook
import com.enriqif.domain.repository.NotebookRepository
import javax.inject.Inject

class NotebookRepositoryImpl @Inject constructor(
    private val api: NotebookApi
) : NotebookRepository {
    override suspend fun getNotebooks() : List<Notebook> {
        return api.getNotebooks().map {
            it.toNotebook()
        }
    }
}