M# HealthCare_Home_screen
A modern Healthcare App Home Screen UI built using Jetpack Compose following MVVM architecture. This project focuses on clean UI, modular composables, reusable components, and scalable architecture suitable for real-world production apps.

✨ Features

📱 Fully built with Jetpack Compose

🧱 MVVM Architecture (ViewModel + UI State)

📦 Local JSON-based data source (mock backend)

🎨 Modern UI with rounded cards, banners & grids

🔍 Functional Search Bar (TextField input support)

🧭 Fixed Bottom Navigation Bar

📚 Sections implemented:

Header with clickable icons

Search Bar

Services Row

Prescription Banner

Categories Grid

Health Packages

Routine Checkup (Men & Women)

Family Care Packages

Women's Wellness

Scans Section

Testimonials (LazyRow cards)

FAQ Section (Expandable)

Footer

##🧱 Architecture
UI (Jetpack Compose)
   ↓
ViewModel (State management)
   ↓
Repository (JSON / Data source)

🛠 Tech Stack

Kotlin

Jetpack Compose

Material 3

MVVM Architecture

State Management

LazyColumn / LazyRow

Custom UI Components

Drawable-based Images (Offline support)

##📂 Project Structure

com.mespl.assignment
│
├── ui/
│   ├── HomeScreen.kt
│   ├── Components.kt
│
├── viewmodel/
│   └── HomeViewModel.kt
│
├── data/
│   ├── model/
│   ├── repository/
│   └── local_json/
│
├── utils/
│   └── drawableFromName.kt

