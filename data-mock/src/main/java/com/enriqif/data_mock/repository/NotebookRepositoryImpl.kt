package com.enriqif.data_mock.repository

import com.enriqif.domain.model.Notebook
import com.enriqif.domain.repository.NotebookRepository
import javax.inject.Inject

class NotebookRepositoryImpl @Inject constructor(): NotebookRepository {

    val notebookList = arrayListOf(
        Notebook(
            "Notebook 1",
            "This is a notebook 1",
            "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"
        ),
        Notebook(
            "Notebook 2",
            "This is a notebook 2",
            "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"
        ),
        Notebook(
            "Notebook 3",
            "This is a notebook 3",
            "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"
        ),
        Notebook(
            "Notebook 4",
            "This is a notebook 4",
            "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"
        ),
        Notebook(
            "Notebook 5",
            "This is a notebook 5",
            "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"
        )
    )

    override suspend fun getNotebooks(): List<Notebook> = notebookList
}