## Features

Modern UI Design: A modern and user-friendly interface with Material3 components.
TopAppBar: A top app bar with a simple header, providing users with easy access.
Animated Cards: Animated cards displaying exercise information for each day. Users can click on the cards to view exercise details.
Dynamic Content Visibility: Each exercise card expands or collapses upon user click, revealing additional information with animated transitions.

## Project Structure

MainActivity.kt: The main entry point of the app, containing the general theme and UI components.
OneWeekApp(): Organizes content areas using a Scaffold and adds the TopAppBar component, creating the general app structure.
ExerciseList(): Component displaying the daily exercise list, managed efficiently with LazyColumn.
ExerciseCard(): Expandable card component for each exercise. When a card is clicked, it expands to provide more information.
TopAppBar(): The section at the top of the app containing the app title.

## Technologies Used

Kotlin: The primary programming language for Android app development.
Jetpack Compose: A modern Android UI toolkit for defining user interfaces.
Material Design 3: Components that follow Material Design principles to ensure visual consistency and accessibility.
Animation API: Used for animations when cards expand or collapse.
