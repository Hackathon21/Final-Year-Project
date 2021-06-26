package com.example.firebaseemail.Modal

data class postItem(

    val ADMITTED_GENERAL: String,
    val ADMITTED_HDU: String,
    val ADMITTED_ICU: String,
    val ADMITTED_ICU_WITH_VENTILATOR: String,
    val ALLOCATED_GENERAL: String,
    val ALLOCATED_HDU: String,
    val ALLOCATED_ICU: String,
    val ALLOCATED_ICU_WITH_VENTILATOR: String,
    val BLOCKED_GENERAL: String,
    val BLOCKED_HDU: String,
    val BLOCKED_ICU: String,
    val BLOCKED_ICU_WITH_VENTILATOR: String,
    val HAS_ICU_BEDS: String,
    val HAS_VENTILATORS: String,
    val HOSPITAL_NAME: String,
    val IS_NEW_HOSPITAL: String,
    val LAST_SYNCED: String,
    val LOCATION: String,
    val NET_AVAILABLE_GENERAL: String,
    val NET_AVAILABLE_HDU: String,
    val NET_AVAILABLE_ICU: String,
    val NET_AVAILABLE_ICU_WITH_VENTILATOR: String,
    val STEIN_ID: String,
    val UID: String
)