package com.enriqif.data.api

import com.enriqif.data.model.NotebookModel
import retrofit2.http.GET

interface NotebookApi {

    @GET("/list")
    suspend fun getNotebooks(): List<NotebookModel>
}