# BingeBoard

BingeBoard is an Android application designed to help users track their favorite TV shows and manage a personal watchlist. It provides features for viewing TV schedules, searching for content, and keeping track of airing series.

## Features

- **TV Schedule**: View upcoming episodes and air dates for TV shows.
- **Search**: Find TV shows using the TVmaze API.
- **Watchlist**: Save shows to your personal list to track their next airing episode.
- **Timezone Conversion**: Automatically converts show air times from the network's timezone to your local device time.
- **Modern UI**: Built with Jetpack Compose, featuring glassmorphism and modern design aesthetics.

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Dependency Injection**: Hilt
- **Networking**: Retrofit & OkHttp
- **JSON Parsing**: Moshi
- **Image Loading**: Coil
- **Local Storage**: DataStore (for watchlist persistence)
- **Lifecycle**: ViewModel, StateFlow, and Compose integration

## Data Sources

The application primarily uses the **TVmaze API** for all TV show data, including search, details, and schedules. 

- **TVmaze**: Primary source for TV shows and schedules.
- **TMDB**: Support for TMDB and movie entries is currently deprecated/skipped in the current implementation in favor of TVmaze's comprehensive TV data.

## License

This project is licensed under the GNU Affero General Public License v3.0 (AGPL-3.0). See the `LICENSE` file for full details.
