# Sample Doordash App
Couple of things to know about this app:
- Fully Kotlin (1.3.0)
- App uses MVVM pattern.
- Uses Dagger, Retrofit, Glide, RX, Jetpack and new Material components
- Handles no data cases and there is an initial UX to load the data.
- Item layout's UX leverages Constaint layout
- Tablet specific screens minimally has been covered.
- Units tests can be found under "test" folder(nothing unexpected here!).
- Implemented using Android Studio version 3.2.1 (latest version from stable channel)
- A Debug apk can be found under project's root folder.
- Demo video can be found under project's root folder

TODOs:
- There is no local cache yet. "Mark as Favorite Location" menu action should cache user's favorite search result.
My choice for this would be probably "Room" and serve restaurants from local cache if network quality is bad.
- There is an error screen but not all the error cases are coverd.
- Nothing optimized in terms of network quality and device configurations..
- Project is not modular, Ideally should be modular not a single module.
