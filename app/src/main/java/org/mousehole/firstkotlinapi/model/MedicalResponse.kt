package org.mousehole.firstkotlinapi.model

data class MedicalResponse(
    val meta: Meta,
    val MedicalResults: List<MedicalResults>
)