package org.mousehole.firstkotlinapi.model

data class FdaResponse(
    val meta: Meta,
    val results: List<FdaResult>
)