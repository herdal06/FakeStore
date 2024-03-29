# FakeStore
Store app based on Fake Store API

#### App Screenshots

| Home | Product Detail |
|:-:|:-:|
| ![Fist](https://github.com/herdal06/FakeStore/blob/master/screenshots/home.png?raw=true) | ![3](https://github.com/herdal06/FakeStore/blob/master/screenshots/product_detail.png?raw=true) | ![3]

Libraries Used
--------------
* [Architecture][10] - Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [lifecycle][22] - As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle.
  * [Repository][18] - Repository modules handle data operations.
  * [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
  * [View Binding][11] - a feature that allows you to more easily write code that interacts with views.
  * [Navigation][50] - Handle everything needed for in-app navigation.
     asynchronous tasks for optimal execution.
  * [Coroutines][51] - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
  * [livedata][52] - is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
  
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Fragment][34] - A basic unit of composable UI.
  * [Layout][35] - Lay out widgets using different algorithms.
  
* Third party and miscellaneous libraries
  * [Retrofit][90] for turns your HTTP API into a Java interface
  * [Coil][92] for image loading
  * [Dagger-Hilt][93] Hilt is the recommended solution for [dependency injection][21] in Android apps, and works seamlessly with Compose.


[11]: https://developer.android.com/topic/libraries/view-binding
[52]: https://developer.android.com/topic/libraries/architecture/livedata
[51]: https://developer.android.com/kotlin/coroutines
[50]: https://developer.android.com/topic/libraries/architecture/navigation/
[10]: https://developer.android.com/jetpack/compose/architecture
[17]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[18]: https://developer.android.com/jetpack/guide#fetch-data
[90]: https://square.github.io/retrofit/
[92]: https://coil-kt.github.io/coil/compose/
[93]: https://developer.android.com/jetpack/compose/libraries#hilt
[30]: https://developer.android.com/guide/topics/ui
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[21]: https://developer.android.com/training/dependency-injection
[22]: https://developer.android.com/guide/components/activities/activity-lifecycle
