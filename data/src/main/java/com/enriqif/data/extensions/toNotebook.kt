package com.enriqif.data.extensions

import com.enriqif.data.model.NotebookModel
import com.enriqif.domain.model.Notebook

fun NotebookModel.toNotebook() = Notebook(
    title = title,
    description = description,
    image = image
)