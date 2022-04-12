package com.enriqif.domain.repository

import com.enriqif.domain.model.Notebook

interface NotebookRepository {
    suspend fun getNotebooks(): List<Notebook>
}