# 📸 FancyGallery App

FancyGallery is a **feature-rich Android app** that integrates **Flickr's API** to fetch and display curated images in an interactive gallery. Users can browse images in a **scrollable grid** or view them on a **world map** based on their geolocation. The app also allows users to click on images to view their original Flickr page.

---

## 🚀 Features

- **📌 Bottom Navigation Bar** – Easily switch between the **Gallery** and **Map** views.
- **🌐 REST API Integration** – Fetches and displays images from **Flickr API** using HTTPS requests.
- **📷 Dynamic Photo Grid** – Loads network images into a **RecyclerView Grid** with smooth scrolling.
- **🗺️ Interactive Map View** – Places images on a world map based on geolocation.
- **🔄 Data Caching & Refresh** – Optimized image loading with **Coil** caching, allowing users to manually refresh images.
- **🔍 WebView Support** – Opens image details directly in a WebView within the app.
- **📍 Custom Map Markers** – Displays image thumbnails as map markers, which are clickable for details.
- **📡 API Key Security** – Securely manages **Flickr API keys** using `apikey.properties`.

---

## 🛠️ Technologies Used

- **Kotlin** – Primary language for Android development.
- **Android Jetpack Components** – ViewModel, Navigation, LiveData.
- **MVVM Architecture** – Ensures separation of concerns for a scalable codebase.
- **Retrofit & Moshi** – For handling network calls and JSON parsing.
- **Coil** – Efficient image loading and caching.
- **OSMDroid** – Open-source map library for displaying geo-tagged images.
- **Room Database** – For managing cached image data.
- **Material Design** – Enhancing UI/UX with modern Android components.

---

## 📌 Future Improvements

- Implement **pagination** for a smoother browsing experience.
- Add **user authentication** for personalized image collections.
- Enhance **marker clustering** on the map for better visualization.

---

