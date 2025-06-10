# 🗞️ Offline-First News App

A modern **Kotlin-based Android news app** that follows the **MVVM architecture** and emphasizes **offline-first functionality**. The app fetches news data from a REST API, displays it in a responsive UI, and stores it locally using Room, allowing users to access news even without an internet connection.

## ✨ Features

* 📡 Fetches latest news articles from an API
* 💾 Offline-first: Caches data using Room for offline access
* ⚡ Smooth and efficient UI with FastAdapter
* 🔁 Automatic updates with LiveData and Coroutines
* 🔍 View articles in detail or in a web view
* 🔐 Proper architecture with separation of concerns

---

## 🛠️ Tech Stack

| Layer         | Libraries/Technologies                                                                                                                                                                                                                                                                                   |
| ------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Language      | Kotlin                                                                                                                                                                                                                                                                                                   |
| Architecture  | [MVVM](https://developer.android.com/topic/architecture), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [Data Binding](https://developer.android.com/topic/libraries/data-binding) |
| Networking    | [Retrofit](https://github.com/square/retrofit), [Moshi](https://github.com/square/moshi), [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)                                                                                                                                      |
| Local Storage | [Room](https://developer.android.com/jetpack/androidx/releases/room)                                                                                                                                                                                                                                     |
| UI Components | [FastAdapter](https://github.com/mikepenz/FastAdapter), [Material Components](https://github.com/material-components/material-components-android)                                                                                                                                                        |
| Utilities     | [Android KTX](https://developer.android.com/kotlin/ktx), [Lifecycle Components](https://developer.android.com/jetpack/androidx/releases/lifecycle)                                                                                                                                                       |

---

## 📦 Project Structure

```text
com.gshoai999.newsapp
├── model
│   ├── api
│   │   ├── ApiService.kt
│   │   └── RetrofitClient.kt
│   ├── database
│   │   ├── NewsDAO.kt
│   │   └── NewsDatabase.kt
│   ├── DataClasses.kt         # Data models for API and DB
├── repo
│   └── NewsRepository.kt      # Repository managing data sources
├── utils
│   ├── Constants.kt
│   └── NetworkUtils.kt
├── view
│   ├── activities
│   │   ├── MainActivity.kt
│   │   ├── OfflineActivity.kt
│   │   ├── ArticleDetailActivity.kt
│   │   └── ArticleWebViewActivity.kt
│   ├── ArticleItem.kt         # FastAdapter item for displaying articles
│   ├── BindingAdapters.kt     # Custom Data Binding adapters
│   └── viewModel
│       ├── NewsViewModel.kt
│       └── NewsViewModelFactory.kt
```

---

## 🚀 Getting Started

### Prerequisites

* Android Studio Giraffe or later
* Android SDK 33+
* Kotlin 1.9+
* Internet connection (for initial API calls)

### Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Shoaibkhalid65/NewsApp.git
   cd OfflineNewsApp
   ```

2. **Open in Android Studio**

   * File > Open > Select the project directory

3. **Add your API key**

   If the API requires a key, add it in a secure place like `local.properties` or use a `BuildConfig` field.

4. **Build and Run**

   * Select a device/emulator and click **Run** ▶️

---

## 📸 Screenshots

### 🏠 MainActivity
![MainActivity](https://github.com/user-attachments/assets/464e0d68-2464-44fc-82dd-966be2fe957c)

### 📴 OfflineActivity
![OfflineActivity](https://github.com/user-attachments/assets/965a50b4-0c3e-4ded-811f-8fb8ead4d030)

### 📰 ArticleDetailActivity
![ArticleDetailActivity](https://github.com/user-attachments/assets/2c3f9484-fb7d-40b5-9cd8-8c3edad6e452)

### 🌐 ArticleWebViewActivity
![ArticleWebViewActivity](https://github.com/user-attachments/assets/5043bda4-645a-4d95-9fc6-b3d54a626ca0)
---

## 📚 Architecture Overview

This app uses the **MVVM pattern** to ensure a clean separation of concerns:

* **Model (Data layer)**: Handles networking (Retrofit + Moshi) and local storage (Room).
* **ViewModel**: Exposes observable data using LiveData and handles logic with Coroutines.
* **View**: Activities and layout files bind to data using Data Binding and FastAdapter for smooth list rendering.

---

## 🤝 Contributing

Contributions are welcome! If you'd like to improve something or report a bug:

1. Fork the repository
2. Create a feature/bugfix branch
3. Push your changes and open a Pull Request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Credits

Developed by [**Muhammad Shoaib Khalid**](https://github.com/Shoaibkhalid65)
Inspired by clean architecture and modern Android development practices.

---

