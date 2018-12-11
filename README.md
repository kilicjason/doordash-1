# Sample Doordash App
Couple of things to know about this app:
- Fully Kotlin (1.3.0)
- App uses MVVM pattern.
- Uses Dagger, Retrofit, Glide, RX, Jetpack and new Material component
- Handles no data cases and initial cases.
- Item UX leverages Constaint layout
- Tablet specific screens minimanlly covered.
- Units tests can be found under "test" folder.
- Implemented using Android Studio version 3.2.1 (latest from stable channel)
- A Debug apk can be found under project's root folder.
- Demo video is attached to email.

TODOs:
- There is no local cache yet. "Mark as Favorite Location" menu action should cache user's favorite search result.
My choice for this would be probably "Room" and serve restaurants from local cache if network quality is bad.
- Theree is an error screen but not all the error cases are coverd.
- Nothing optimized in terms of network quality and device configurations..
- It is not modular, Ideally should be modular.
