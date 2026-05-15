📜 Kavya Kanaja – Kannada Poetry Library App

A modern Android application built with **Jetpack Compose + Room + MVVM** to preserve, explore and celebrate Kannada poetry digitally.

🌟 Overview

Kavya Kanaja is a fully offline-first Android application that provides a curated digital library of Kannada poems from legendary poets like Kuvempu, D. R. Bendre and others.
The app combines modern Android architecture with cultural preservation, making classical literature accessible to today’s mobile users.
This project demonstrates real-world Android development using **Clean Architecture, MVVM, Room Database and Jetpack Compose UI**.

🎯 Problem Statement

Despite the richness of Kannada literature, there are very few modern, well-designed mobile apps that:
* Preserve Kannada poems digitally
* Provide structured browsing by authors and categories
* Work offline without internet
* Offer a modern, smooth and intuitive UI
Kavya Kanaja solves this problem by creating a structured digital poetry library with offline storage and a modern user experience.

✨ Key Features

📖 Poetry Library
* Browse a curated collection of Kannada poems
* Structured and categorized content
* Offline storage using Room Database

🖋️ Author Exploration
* View legendary Kannada poets
* Explore poems by specific authors
* Author biography and description

⭐ Favorites System
* Mark poems as favorite
* Quick access to saved poems

📅 Poem of the Day
* Dynamic daily featured poem
* Encourages daily reading habit

➕ Add New Poems
* Add your own poems to the library
* Persisted locally using Room DB

🧭 Modern Navigation
* Bottom Navigation Bar
* Multi-screen architecture using NavGraph

🧱 Architecture
This project follows **Clean MVVM Architecture**:

UI (Jetpack Compose)
   ↓
ViewModel (State management)
   ↓
Repository (Single source of truth)
   ↓
Room Database (Local storage)

Why this architecture?

✔ Scalable
✔ Testable
✔ Maintainable
✔ Industry standard


# 🛠️ Tech Stack

| Category             | Technology                 |
| -------------------- | -------------------------- |
| Language             | Kotlin                     |
| UI Toolkit           | Jetpack Compose            |
| Architecture         | MVVM                       |
| Database             | Room Database              |
| Dependency Injection | ViewModel Factory          |
| Navigation           | Jetpack Navigation Compose |
| State Management     | StateFlow / LiveData       |
| IDE                  | Android Studio             |

📂 Project Structure

com.example.kavyakanaja
│
├── data
│   ├── dao
│   │   ├── AuthorDao
│   │   └── PoemDao
│   ├── db
│   │   └── AppDatabase
│   └── repository
│       ├── AuthorRepository
│       ├── PoemRepository
│       └── PoemData
│
├── model
│   ├── Author
│   ├── Poem
│   ├── PoemWithAuthor
│   └── Poet
│
├── ui
│   ├── components
│   │   ├── BottomBar
│   │   ├── PoemItem
│   │   └── PoetCard
│   ├── navigation
│   │   ├── NavGraph
│   │   └── Routes
│   ├── screens
│   │   ├── HomeScreen
│   │   ├── LibraryScreen
│   │   ├── AuthorsScreen
│   │   ├── FavoritesScreen
│   │   ├── AddPoemScreen
│   │   └── PoemDetailScreen
│   └── theme
│
├── viewmodel
│   ├── AuthorViewModel
│   ├── PoemViewModel
│   └── ViewModelFactory
│
└── MainActivity

📱 App Screenshots

🏠 Home Screen – Poem of the Day
* Daily highlighted poem
* Clean and modern Compose UI

📚 Library Screen – All Poems
* Scrollable poetry list
* Beautiful card-based layout

👨‍🏫 Authors Screen – Kannada Legends
* Explore poets and their works
* Rich author profiles

🚀 How to Run the Project
1️⃣ Clone the Repository
bash
git clone https://github.com/kcchandana7/kavyakanaja.git

2️⃣ Open in Android Studio
* Open Android Studio
* Select **Open Project**
* Choose the cloned folder

3️⃣ Run the App
* Connect device or start emulator
* Click ▶ Run

demo link: https://appdistribution.firebase.google.com/testerapps/1:666899114528:android:f464e556bf5522108eea45/releases/0o4qpvb5mcsgo?utm_source=firebase-console

🎓 Learning Highlights
This project demonstrates:
* Real MVVM implementation in Compose
* Room Database relationships (Poem ↔ Author)
* Navigation Compose architecture
* Repository pattern
* Clean UI component separation
* Scalable folder structure
* Offline-first mobile app design

📈 Future Improvements
* Cloud sync with Firebase
* Search functionality 🔍
* Dark mode 🌙
* Share poems feature 📤
* Multi-language support 🌍
* Play Store release 🚀

👩‍💻 Developer

K C Chandana

Android Developer | Kotlin | Jetpack Compose
Passionate about building apps that blend technology + culture

⭐ Support
If you like this project, consider giving it a ⭐ on GitHub!

