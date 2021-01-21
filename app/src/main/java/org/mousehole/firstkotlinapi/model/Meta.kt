package org.mousehole.firstkotlinapi.model

data class Meta(
    val disclaimer: String,
    val last_updated: String,
    val license: String,
    val results: Results,
    val terms: String
)