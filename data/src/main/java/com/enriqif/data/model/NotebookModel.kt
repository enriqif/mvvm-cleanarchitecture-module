package com.enriqif.data.model

import com.google.gson.annotations.SerializedName

data class NotebookModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String
)
