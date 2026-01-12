package com.mespl.assignment.data.model

data class FamilyCarePackageItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: String,
    val oldPrice: Int,
    val newPrice: Int,
    val discount: Int
)
