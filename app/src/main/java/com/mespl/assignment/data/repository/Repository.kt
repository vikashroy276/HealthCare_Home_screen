package com.mespl.assignment.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mespl.assignment.HomeUiState
import com.mespl.assignment.data.model.CategoryItem
import com.mespl.assignment.data.model.DataItem
import com.mespl.assignment.data.model.FamilyCarePackageItem
import com.mespl.assignment.data.model.FaqItem
import com.mespl.assignment.data.model.RoutineItem
import com.mespl.assignment.data.model.ScanItem
import com.mespl.assignment.data.model.TestimonialItem
import com.mespl.assignment.data.model.WomensCareItem
import com.mespl.assignment.data.model.WomensPackageItem
import org.json.JSONObject

class Repository(private val context: Context) {

    fun loadHomeData(): HomeUiState {
        val json = context.assets.open("home_data.json")
            .bufferedReader().use { it.readText() }

        val obj = JSONObject(json)


        val services: List<DataItem> = Gson().fromJson(
            obj.getJSONArray("services").toString(),
            object : TypeToken<List<DataItem>>() {}.type
        )

        val categories: List<CategoryItem> = Gson().fromJson(
            obj.getJSONArray("categories").toString(),
            object : TypeToken<List<CategoryItem>>() {}.type
        )

        val scans: List<ScanItem> = Gson().fromJson(
            obj.getJSONArray("scans").toString(),
            object : TypeToken<List<ScanItem>>() {}.type
        )

        val faq: List<FaqItem> = Gson().fromJson(
            obj.getJSONArray("faq").toString(),
            object : TypeToken<List<FaqItem>>() {}.type
        )

        val testimonials: List<TestimonialItem> = Gson().fromJson(
            obj.getJSONArray("testimonials").toString(),
            object : TypeToken<List<TestimonialItem>>() {}.type
        )

        val womensCare: List<WomensCareItem> = Gson().fromJson(
            obj.getJSONArray("womensCare").toString(),
            object : TypeToken<List<WomensCareItem>>() {}.type
        )

        val womensPackages: List<WomensPackageItem> = Gson().fromJson(
            obj.getJSONArray("womensPackages").toString(),
            object : TypeToken<List<WomensPackageItem>>() {}.type
        )

        val familyCare: List<FamilyCarePackageItem> = Gson().fromJson(
            obj.getJSONArray("familyCarePackages").toString(),
            object : TypeToken<List<FamilyCarePackageItem>>() {}.type
        )

        val menRoutine: List<RoutineItem> = Gson().fromJson(
            obj.getJSONArray("routineMen").toString(),
            object : TypeToken<List<RoutineItem>>() {}.type
        )

        val womenRoutine: List<RoutineItem> = Gson().fromJson(
            obj.getJSONArray("routineWomen").toString(),
            object : TypeToken<List<RoutineItem>>() {}.type
        )

        return HomeUiState(
            services = services,
            categories = categories,
            scans = scans,
            faq = faq,
            testimonials = testimonials,
            womensCare = womensCare,
            womensPackages = womensPackages,
            familyCarePackages = familyCare,
            routineMen  = menRoutine,
            routineWomen  = womenRoutine

        )
    }
}

