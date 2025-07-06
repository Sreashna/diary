# 🧠 SoulScribe – A Personal Diary & Mood Journal App

**SoulScribe** is a smart and calming diary app built with Kotlin and Jetpack Compose. It enables users to **speak, type, or upload images to share their emotions** and reflect on their daily life. The app is designed with a focus on **mental wellness, expressive writing**, and **ease of use**.

---

## 🧩 Features

### 🎤 Voice-to-Text Input
- Users can speak naturally, and the app converts their voice into written text using the `SpeechRecognizer` API.
- Ideal for moments when typing feels hard.

### 📝 Text Entry & Daily Journaling
- Add a title and freely type what's on your mind.
- Custom date picker allows selecting the journal date.
- Input validation ensures quality data is saved.

### 🖼️ Image Upload
- Attach a photo (from gallery) to your journal entry.
- Helpful for expressive journaling and memory retention.

### 💾 Save & View Past Entries
- Entries are stored in memory (with RoomDB integration possible).
- View saved memories in a clean, scrollable layout.

### 🎨 Modern UI with Compose
- Built entirely using **Jetpack Compose**.
- Custom color palette (light pinks, soft browns) for a calm emotional tone.
- Consistent theming across all screens.

---

## 🛠️ Tech Stack

| Layer        | Technology                            |
|--------------|----------------------------------------|
| Language     | Kotlin                                 |
| UI           | Jetpack Compose, Material 3            |
| Architecture | MVVM (Model-View-ViewModel)            |
| Speech Input | Android `SpeechRecognizer`             |
| Navigation   | Jetpack Navigation (Compose)           |
| Image Upload | `ActivityResultContracts.GetContent()` |
| State Mgmt   | `remember`, `mutableStateOf`           |

---

## 🎯 Use Case & Problem Solved

> Many people struggle to write consistently, especially when they are emotional or tired. **SoulScribe** solves this by allowing users to simply speak their thoughts, upload a meaningful image, and save their memories with just a few taps.

This makes the app:
- Ideal for **daily mental health check-ins**.
- Useful as a **lightweight therapeutic tool**.
- Easy to use for both younger and older users.

---

## 🧪 How It Works (Step by Step)

1. **Launch app** → Bottom navigation opens main sections: Journal, Write, Memories.
2. **Write screen** lets user:
   - Enter title.
   - Speak thoughts → converted to text.
   - Pick date → with a native `DatePickerDialog`.
   - Upload image → stored using `ContentResolver`.
3. **Save** stores the entry in memory (can be extended to Room or Firebase).
4. **Favorites screen** shows all entries with date, title, content, and image.
5. **MVVM** architecture ensures logic and UI are cleanly separated.

---

## 📱 Screenshots

> Include screenshots in your repo under `/screenshots/` folder and reference them like below:

| Add Diary | Voice Input | Memories |
|-----------|-------------|----------|
| ![](screenshots/add_entry.png) | ![](screenshots/voice_input.png) | ![](screenshots/memories.png) |

---

## 🚀 Setup Instructions

```bash
git clone https://github.com/Sreashna/diary.git
cd diary
