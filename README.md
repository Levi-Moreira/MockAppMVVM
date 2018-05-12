# MockAppMVVM
A sample app structure using the MVVM architecture.


This app (for now) simply list the top 10 StackOverflow answerers as well as info about the current user profile.

The libs used:

- Retrofit[1] - For network calls to the SE Rest API
- Dagger2[2] - For Dependency Injection
- RxJava2[3] - For interfacing the Repository(Network and Local) layer with the view model layer
- Glide[4] - For efficient image loading

This app is also an experiment on Architecture Components, so it also uses:
- LiveData[5] - All around the app
- ViewModel[6] - All around the app
- LifeCycle[7] - All around the app
- Room[8] (not yet)
- Navigation[9] (not yet)
- Paging[10] - In the TopUsersFragment


[1]: http://square.github.io/retrofit/
[2]: https://github.com/google/dagger
[3]: https://github.com/ReactiveX/RxJava
[4]: https://github.com/bumptech/glide
[5]: https://developer.android.com/topic/libraries/architecture/livedata
[6]: https://developer.android.com/topic/libraries/architecture/viewmodel
[7]: https://developer.android.com/reference/android/arch/lifecycle/Lifecycle
[8]: https://developer.android.com/topic/libraries/architecture/room
[9]: https://developer.android.com/topic/libraries/architecture/navigation
[10]: https://developer.android.com/topic/libraries/architecture/paging/
