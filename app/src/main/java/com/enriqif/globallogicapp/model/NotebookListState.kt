package com.enriqif.globallogicapp.model

import com.enriqif.domain.model.Notebook

data class NotebookListState(
    val isLoading: Boolean = false,
    val notebooks: List<Notebook> = emptyList(),
    val error: String = ""
)