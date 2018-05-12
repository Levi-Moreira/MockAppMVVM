# MockAppMVVM
A sample app structure using the MVVM architecture.


This app (for now) simply list the top 10 StackOverflow answerers as well as info about the current user profile.

The libs used:

- [Retrofit](http://square.github.io/retrofit/) - For network calls to the SE Rest API
- [Dagger2](https://github.com/google/dagger) - For Dependency Injection
- [RxJava2](https://github.com/ReactiveX/RxJava) - For interfacing the Repository(Network and Local) layer with the view model layer
- [Glide](https://github.com/bumptech/glide) - For efficient image loading

This app is also an experiment on Architecture Components, so it also uses:
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - All around the app
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - All around the app
- [LifeCycle](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle) - All around the app
- [Room](https://developer.android.com/topic/libraries/architecture/room) (not yet)
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation) (not yet)
- [Paging](https://developer.android.com/topic/libraries/architecture/paging/) - In the TopUsersFragment

