package com.mespl.assignment.data.model

data class WomensPackageItem(
    val id: Int,
    val badge: String,
    val title: String,
    val description: String,
    val tests: String,
    val reports: String,
    val fasting: String,
    val price: Int,
    val originalPrice: Int,
    val emiPrice: Int
)
