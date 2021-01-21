package org.mousehole.firstkotlinapi.model

data class MedicalResults(
    val address_1: String,
    val address_2: String,
    val center_classification_date: String,
    val city: String,
    val classification: String,
    val code_info: String,
    val country: String,
    val distribution_pattern: String,
    val event_id: String,
    val initial_firm_notification: String,
    val more_code_info: Any,
    val openfda: Openfda,
    val postal_code: String,
    val product_description: String,
    val product_quantity: String,
    val product_type: String,
    val reason_for_recall: String,
    val recall_initiation_date: String,
    val recall_number: String,
    val recalling_firm: String,
    val report_date: String,
    val state: String,
    val status: String,
    val termination_date: String,
    val voluntary_mandated: String
)