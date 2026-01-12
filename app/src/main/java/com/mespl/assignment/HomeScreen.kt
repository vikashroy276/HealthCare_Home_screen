package com.mespl.assignment

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mespl.assignment.data.model.BottomNavItem
import com.mespl.assignment.data.model.CategoryItem
import com.mespl.assignment.data.model.DataItem
import com.mespl.assignment.data.model.FamilyCarePackageItem
import com.mespl.assignment.data.model.FaqItem
import com.mespl.assignment.data.model.RoutineItem
import com.mespl.assignment.data.model.ScanItem
import com.mespl.assignment.data.model.TestimonialItem
import com.mespl.assignment.data.model.WomensCareItem
import com.mespl.assignment.data.model.WomensPackageItem

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    val state = viewModel.uiState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 90.dp)
        ) {

            item { Header() }
            item { ServicesRow(state.services) }
            item { PrescriptionBanner() }
            item { CategoryGrid(state.categories) }
            item { HealthPackages(state.womensPackages) }
            item { BookLabTestBanner() }
            item { MenRoutine(state.routineMen) }
            item { WomenRoutine(state.routineWomen) }
            item { FamilyCare(state.familyCarePackages) }
            item { WomensHealthPackages(state.womensPackages) }
            item { WomensCare(state.womensCare) }
            item { ScanGrid(state.scans) }
            item { Testimonial(state.testimonials) }
            item { FaqSection(state.faq) }
            item { Footer() }
        }
        HomeBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Header() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF0F6B6B),
                shape = RoundedCornerShape(
                    bottomStart = 40.dp,
                    bottomEnd = 40.dp
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(modifier = Modifier.weight(1f)) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = "Namaste Vikash",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                        }
                    ) {
                        Text(
                            text = "Noida, Sec - 52, Delhi-NCR",
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 13.sp
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier.clickable {
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = Color.White
                    )

                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color.Red, CircleShape)
                            .align(Alignment.TopEnd)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_wallet),
                    contentDescription = "Wallet",
                    modifier = Modifier
                        .size(22.dp)
                        .clickable {
                        },
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(14.dp))

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account Circle",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            SearchBar()

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Healthcare\nIt’s Priority",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}


@Composable
fun SearchBar() {

    var query by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(52.dp)
            .shadow(8.dp, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Black
            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = query,
                onValueChange = { query = it },
                placeholder = {
                    Text(
                        text = "Search for \"X-Ray\"",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(22.dp)
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(Color(0xFFFFF3E0), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_mic),
                    contentDescription = "Mic",
                    tint = Color(0xFFFF9800)
                )
            }
        }
    }
}


@Composable
fun ServicesRow(services: List<DataItem>) {

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        services.forEach { service ->

            val imageResId = remember(service.image) {
                val id = context.resources.getIdentifier(
                    service.image.lowercase(),
                    "drawable",
                    context.packageName
                )
                if (id != 0) id else R.drawable.ic_profile_placeholder
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(100.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(
                            Color(0xFFE8F4F4),
                            RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(imageResId),
                        contentDescription = service.title,
                        modifier = Modifier.size(90.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    text = service.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = service.subtitle,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PrescriptionBanner() {

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF0FA3A3))
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 140.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Book Via Doctor Prescription",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = "Our experts will book the test for you as per your prescription.",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 13.sp,
                    lineHeight = 18.sp
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Upload Now",
                    color = Color(0xFF0FA3A3),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(180.dp)
                .align(Alignment.CenterEnd)
        ) {

            Box(
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 40.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.15f),
                        shape = CircleShape
                    )
            )

            Image(
                painter = painterResource(R.drawable.pracption),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp),
                contentScale = ContentScale.Fit
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Dot(isActive = true)
            Dot(isActive = false)
            Dot(isActive = false)
        }
    }
}

@Composable
fun Dot(isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(if (isActive) 10.dp else 8.dp)
            .background(
                color = if (isActive) Color.White else Color.White.copy(alpha = 0.5f),
                shape = CircleShape
            )
    )
}

@Composable
fun CategoryGrid(categories: List<CategoryItem>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Doctor-Curated Health Checkup Packages",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(Modifier.height(12.dp))

        categories.chunked(3).forEach { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                rowItems.forEach { category ->
                    CategoryCard(
                        category = category,
                        modifier = Modifier.weight(1f)
                    )
                }

                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun CategoryCard(category: CategoryItem, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .aspectRatio(0.9f)
            .clip(RoundedCornerShape(20.dp))
            .background(getPastelColor(category.id))
            .padding(12.dp)
    ) {

        Text(
            text = category.name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(drawableFromName(category.image)),
            contentDescription = category.name,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
    }
}


@Composable
fun HealthPackages(list: List<WomensPackageItem>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Top Booked Health Checkup Packages",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list, key = { it.id }) {
                WomensPackageCard(it)
            }
        }
    }
}


@Composable
fun BookLabTestBanner( imageName: String = "book_lab_test" ) {
    val imageRes = drawableFromName(imageName)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(190.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF5BAF6B))
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 120.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Book Lab Test at Home",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Safe & Convenient sample collection by trained experts at your doorstep.",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    lineHeight = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Book Now",
                    color = Color(0xFF003F4A),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(180.dp)
                .align(Alignment.CenterEnd)
        ) {


            Box(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 40.dp)
                    .background(Color.White.copy(alpha = 0.25f), CircleShape)
            )

            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}


@Composable
fun MenRoutine(list: List<RoutineItem>) {

    Column {

        Text(
            text = "Routine Health Checkup for Men",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(list) { item ->
                RoutineAvatar(item)
            }
        }
    }
}


@Composable
fun WomenRoutine(list: List<RoutineItem>) {

    Column {

        Text(
            text = "Routine Health Checkup for Women",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(list) { item ->
                RoutineAvatar(item)
            }
        }
    }
}

@Composable
fun RoutineAvatar(item: RoutineItem) {

    val context = LocalContext.current

    val imageResId = remember(item.image) {
        val id = context.resources.getIdentifier(
            item.image.lowercase(),
            "drawable",
            context.packageName
        )

        if (id != 0 && id != android.R.drawable.btn_default) {
            id
        } else {
            R.drawable.ic_launcher_foreground
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(90.dp)
    ) {

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFFE6EEF6), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(imageResId),
                contentDescription = item.title,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun FamilyCare(list: List<FamilyCarePackageItem>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Family Care Packages",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(list) { item ->
                FamilyCareCard(item)
            }
        }
    }
}

@Composable
fun FamilyCareCard(item: FamilyCarePackageItem) {
    val imageRes = drawableFromName(item.image)
    Box(
        modifier = Modifier
            .width(360.dp)
            .height(170.dp)
    ) {

        Box(
            modifier = Modifier
                .width(340.dp)
                .height(170.dp)
                .background(
                    color = Color(0xFF003F4A),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
                    .width(200.dp)
            ) {

                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = item.subtitle,
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Column {
                            Text(
                                text = "Rs. ${item.oldPrice}/-",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )

                            Text(
                                text = "Rs. ${item.newPrice}/-",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = "${item.discount}%\nOFF",
                            color = Color(0xFF5BAF2F),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.BottomEnd)
                .padding(end = 8.dp)
                .offset(x = (-13).dp)
                .background(Color(0xFFBFD9FF), CircleShape),
            contentAlignment = Alignment.BottomCenter
        )
        {
            Image(
                painter = painterResource(imageRes),
                contentDescription = item.title,
                modifier = Modifier.fillMaxHeight(0.9f),
                contentScale = ContentScale.Fit
            )
        }
    }
}


@Composable
fun WomensHealthPackages(list: List<WomensPackageItem>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Women’s Health & Wellness",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list, key = { it.id }) {
                WomensPackageCard(it)
            }
        }
    }
}


@Composable
fun WomensPackageCard(item: WomensPackageItem) {

    Column(
        modifier = Modifier
            .width(320.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .background(Color(0xFFEAF3F3), RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = item.badge,
                    fontSize = 12.sp
                )
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFF0F6B6B), RoundedCornerShape(10.dp))
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "Packages",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.description,
            fontSize = 12.sp,
            color = Color.Gray,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PackageFeatureItem("Tests Included", item.tests)
            PackageFeatureItem("Reports within", item.reports)
            PackageFeatureItem("Fasting Required", item.fasting)
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.weight(1f)) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "₹ ${item.price}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "₹${item.originalPrice}",
                        fontSize = 13.sp,
                        color = Color.Red,
                        textDecoration = TextDecoration.LineThrough
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Or Pay ₹ ${item.emiPrice} with Annual plan.",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003D3D)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Book Now →", color = Color.White, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun PackageFeatureItem(
    title: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(34.dp)
                .background(Color(0xFF6FBF73), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            fontSize = 11.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Text(
            text = value,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun WomensCare(list: List<WomensCareItem>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Holistic Women’s Care",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        list.chunked(4).forEach { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                rowItems.forEach { item ->
                    WomensCareCard(
                        item = item,
                        modifier = Modifier.weight(1f)
                    )
                }

                repeat(4 - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun WomensCareCard(
    item: WomensCareItem,
    modifier: Modifier = Modifier
) {
    val imageRes = drawableFromName(item.image)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .background(
                    color = Color(0xFFDFF1F2),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ScanGrid(scans: List<ScanItem>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "X-Ray, CT Scan and MRI",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        scans.chunked(3).forEach { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                rowItems.forEach { scan ->
                    ScanCard(
                        scan = scan,
                        modifier = Modifier.weight(1f)
                    )
                }

                repeat(3 - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun ScanCard(
    scan: ScanItem,
    modifier: Modifier = Modifier
) {

    val imageRes = drawableFromName(scan.image)
    Box(
        modifier = modifier
            .aspectRatio(0.9f)
            .background(
                color = Color(0xFFDFF1F2),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(14.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = scan.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = scan.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(20.dp)
                .background(Color(0xFF0F6B6B), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open",
                tint = Color.White,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}


@Composable
fun Testimonial(testimonials: List<TestimonialItem>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {

        Text(
            text = "Testimonials",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = testimonials,
                key = { it.id }
            ) {
                TestimonialCard(it)
            }
        }
    }
}

@Composable
fun TestimonialCard(item: TestimonialItem) {

    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color.White, RoundedCornerShape(30.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray, // outline color
            )
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray, // outline color
                        shape = CircleShape
                    )
                    .padding(2.dp) // space between border & image
            ) {

            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Text(
                    text = item.role,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "“${item.message}”",
            fontSize = 14.sp,
            color = Color.DarkGray,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun FaqSection(faqs: List<FaqItem>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = "Frequently Asked Questions",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        faqs.forEach { faq ->
            FaqItemView(faq)
        }
    }
}

@Composable
fun FaqItemView(item: FaqItem) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color(0xFFF7F7F7), RoundedCornerShape(12.dp))
            .clickable { expanded = !expanded }
            .padding(16.dp)
            .animateContentSize()
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = item.question,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = if (expanded)
                    Icons.Default.KeyboardArrowUp
                else
                    Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }

        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.answer,
                fontSize = 13.sp,
                color = Color.DarkGray,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun Footer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Live Healthy", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Text("Crafted with ❤ in India", color = Color.Gray, fontSize = 12.sp)
        Spacer(Modifier.height(8.dp))
        Text("PROD - v1.0.0", color = Color.LightGray, fontSize = 10.sp)
    }
}

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 2,
    onItemSelected: (Int) -> Unit = {}
) {

    val items = listOf(
        BottomNavItem("Home", painterResource(R.drawable.ic_home)),
        BottomNavItem("Reports", painterResource(R.drawable.ic_reports)),
        BottomNavItem("Lab Tests", painterResource(R.drawable.ic_lab)),
        BottomNavItem("Bookings", painterResource(R.drawable.ic_bookings)),
        BottomNavItem("Profile", painterResource(R.drawable.ic_profile))
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
            )
            .padding(top = 12.dp, bottom = 20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items.forEachIndexed { index, item ->

                val isSelected = index == selectedIndex

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onItemSelected(index) },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = item.icon,              //  FIXED
                        contentDescription = item.title,
                        tint = Color.Unspecified,          //  REQUIRED for vector XML
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.Black else Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun drawableFromName(name: String): Int {
    val context = LocalContext.current
    return remember(name) {
        val id = context.resources.getIdentifier(
            name.lowercase(),
            "drawable",
            context.packageName
        )
        if (id != 0) id else R.drawable.ic_profile_placeholder
    }
}

fun getPastelColor(id: Int): Color {
    return when (id % 3) {
        0 -> Color(0xFFD6ECEB) // greenish
        1 -> Color(0xFFFFE5E2) // pinkish
        else -> Color(0xFFDCEAF6) // bluish
    }
}
