# MockAppMVVM
A sample app structure using the MVVM architecture.


This app (for now) simply list the top 10 StackOverflow answeres as well as info about the current user profile.
The lib uses:

- Retrofit - For network calls to the SE Rest API
- Dagger2 - For Dependency Injection
- RxJava2 - For interfacing the Repository(Network and Local) layer with the view model layer

This app is also an experiment on Architecture Components, so it also uses:
- LiveData 
- ViewModel
- LifeCycle
- Room
- Navigation (not yet)
- Paging (not yet)
