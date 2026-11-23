# FamilyApp

FamilyApp is an Android app that helps a family organise everyday life in one place: events, meals, routines, to-dos, checklists and photos.

It is written in Java using classic Android Views, with one screen (Activity) per feature.

## Features

| Feature | Screen | What it does |
|---|---|---|
| **Calendar / Events** | `AddEvents`, `viewCalendar` | Shows today's date and opens the phone's calendar app with a new event ready to fill in. Also opens a month calendar view. |
| **Meal Planner** | `MealPlanner` | Pick a meal from a menu (Pancake, Burger, Shawarma, Poutine, Mac and Cheese, Sushi, Pizza), or spin a wheel to choose a school lunch at random. |
| **Timer** | `FamAppTimer` | Countdown timers for family routines: **Get Ready** (15 min), **Watch Media** (60 min) and **Clean Up** (30 min), with start, pause and reset. |
| **To-do List** | `ToDoList` | Add tasks; tap a task to tick it off and it disappears after a second. |
| **Checklist** | `CheckList` | Ready-made packing lists for **Winter**, **Summer** and a **First-Aid Kit**, each with a header image. |
| **Capture Moments** | `PhotoGallery` | Opens the camera, takes a photo and shows it with a "See Your Smile!!!" message. |
| **Activities** | `ActivitiesFun` | Kids' activities screen (ideas coming soon). |
| **Contact Us** | `ContactUs` | Thank-you and credits screen with two image slideshows. |
| **Monthly Schedule** | – | Button on the home screen; screen not built yet. |

The app supports portrait and landscape layouts (`layout/` and `layout-land/`) and uses Google Fonts such as Boogaloo, Atma, Amatic SC and Alegreya.

## Tech stack

- **Language:** Java 8
- **UI:** Android Views (XML layouts), ConstraintLayout, RecyclerView, ListView, Spinner, CalendarView
- **Libraries:** AndroidX AppCompat 1.4.0, Material Components 1.4.0, ConstraintLayout 2.1.2
- **Build:** Gradle 7.0.2, Android Gradle Plugin 7.0.3
- **SDK:** minimum Android 5.0 (API 21), target and compile Android 12 (API 31)
- **Permissions:** Camera

## Project structure

```
FamilyApp/
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/shajitha/familyapp/
│       │   ├── MainActivity.java       # Home screen and navigation
│       │   ├── AddEvents.java          # Add an event to the phone's calendar
│       │   ├── viewCalendar.java       # Month calendar view
│       │   ├── MealPlanner.java        # Menu and spin-the-wheel lunch picker
│       │   ├── FamAppTimer.java        # Routine countdown timers
│       │   ├── ToDoList.java           # To-do list
│       │   ├── CheckList.java          # Packing / first-aid checklists
│       │   ├── ChecklistAdapter.java   # RecyclerView adapter (header and item rows)
│       │   ├── ChecklistItems.java     # Checklist data model
│       │   ├── PhotoGallery.java       # Camera capture
│       │   ├── ActivitiesFun.java      # Kids' activities
│       │   ├── Reading.java            # Reading (not linked yet)
│       │   └── ContactUs.java          # Credits and slideshow
│       └── res/
│           ├── layout/  layout-land/   # Portrait and landscape screens
│           ├── drawable/               # Images and icons
│           ├── font/                   # Google Fonts
│           └── values/                 # Strings, colours, themes, food menu
├── build.gradle
├── settings.gradle
└── gradle/wrapper/
```

## Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/ShajiHub/FamilyApp.git
   ```
2. Open the `FamilyApp` folder in Android Studio (Arctic Fox 2020.3.1 or newer, with JDK 11).
3. Let Gradle sync, then run the `app` configuration on an emulator or device with Android 5.0 or later.

## Known issues

- The **Monthly Schedule** button has no screen behind it yet, and tapping it closes the app.
- To-do items are not saved; they are lost when the app closes or the phone rotates.
- Checklists are fixed and items cannot be ticked.
- Photos are not saved, and the camera screen closes the app if you cancel the camera.
- The timer closes the app if Pause or Reset is pressed before a timer has started.
- The meal wheel spins but does not show which meal was chosen.

## Roadmap

Planning improvements is underway. See the issues and future updates to this README.

## Author

Developed by [ShajiHub](https://github.com/ShajiHub).
