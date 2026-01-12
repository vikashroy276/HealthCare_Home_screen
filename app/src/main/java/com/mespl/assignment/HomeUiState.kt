package com.mespl.assignment

import com.mespl.assignment.data.model.CategoryItem
import com.mespl.assignment.data.model.DataItem
import com.mespl.assignment.data.model.FamilyCarePackageItem
import com.mespl.assignment.data.model.FaqItem
import com.mespl.assignment.data.model.RoutineItem
import com.mespl.assignment.data.model.ScanItem
import com.mespl.assignment.data.model.TestimonialItem
import com.mespl.assignment.data.model.WomensCareItem
import com.mespl.assignment.data.model.WomensPackageItem

data class HomeUiState(
    val services: List<DataItem> = emptyList(),
    val categories: List<CategoryItem> = emptyList(),
    val scans: List<ScanItem> = emptyList(),
    val faq: List<FaqItem> = emptyList(),
    val testimonials: List<TestimonialItem> = emptyList(),
    val womensCare: List<WomensCareItem> = emptyList(),
    val womensPackages: List<WomensPackageItem> = emptyList(),
    val familyCarePackages: List<FamilyCarePackageItem> = emptyList(),
    val routineMen: List<RoutineItem> = emptyList(),
    val routineWomen: List<RoutineItem> = emptyList()


)