<h2 style="margin-bottom: 0;" align="center">Easy T3ch - HILT - MVVM</h2>

<p align="center">
<img src="https://user-images.githubusercontent.com/15268903/166077463-ee3084ca-92a6-445d-937b-0b5d9cfd6b91.png" height="100" width="100">
<h3 style="margin-top: 0;" align="center">Simple app built on top of Dagger Hilt & other best practices like MVVM, Navigation, RxJava, Room, Databinding, Offline Caching.</h3>
</p>
	
## App Screenshots
<table>
  <tr>
     <td align="center">Splash</td>
     <td align="center">Home</td>
  </tr>
  <tr>
    <td valign="top"><img src="https://user-images.githubusercontent.com/15268903/166077758-c295f0d8-b2be-4a7c-96c1-5d44c5942358.png" height="400" width="200"></td>
    <td valign="top"><img src="https://user-images.githubusercontent.com/15268903/166077349-3e552224-86b2-4f57-82b8-a4f71bb6ae6e.png" height="400" width="200"></td>
  </tr>
 </table>
 <br>


## Features

* Loads data from rest api
* Play Videos from youtube

### Built With

* Android Studio Bumblebee | 2021.1.1 The latest version can be downloaded from [here](https://developer.android.com/studio/)
* Build gradle 3.6.4
* Android SDK 32
* Kotlin Version 1.6.20

## Libraries  & Tools Used

- [Dagger Hilt](https://dagger.dev/hilt/)
- [RxJava](https://github.com/ReactiveX/RxJava)   
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)   
- [RxKotlin](https://github.com/ReactiveX/RxKotlin)    
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/)   
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)   
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)   
- [Data Binding](https://developer.android.com/topic/libraries/data-binding)   
- [RoomDB](https://developer.android.com/topic/libraries/architecture/room)   
- [Retrofit](https://square.github.io/retrofit/)   
- [OkHttp](https://github.com/square/okhttp)   
- [Glide](https://github.com/bumptech/glide)   
- [Material Design](https://material.io/develop/android/docs/getting-started/)  

### Install the apk

<a href="https://link.shaj.dev/ET-HILT"><img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" width="185" height="70"/></a>

Go to the following [link](https://link.shaj.dev/ET-HILT) to download the app.


## Architecture
The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern and a lot more.

<img src="https://user-images.githubusercontent.com/15268903/166078769-ea0920be-322c-4ff6-9c9f-1b78f899c580.png">

### Directory Structure

The following is a high level overview of relevant files and folders.

```
└── easyt3ch
    └── hilt
        ├── App.kt
        ├── core
        │   ├── Constants.kt
        │   ├── DataBindingAdapter.kt
        │   └── base
        │       ├── BaseActivity.kt
        │       ├── BaseAdapter.kt
        │       ├── BaseFragment.kt
        │       ├── BaseViewHolder.kt
        │       └── BaseViewModel.kt
        ├── db
        │   ├── AppDatabase.kt
        │   └── dao
        │       └── HomeVideoDao.kt
        ├── di
        │   └── modules
        │       ├── DatabaseModule.kt
        │       └── NetModule.kt
        ├── domain
        │   ├── VideoPostApi.kt
        │   ├── datasource
        │   │   ├── HomeVideoLocalDataSource.kt
        │   │   └── HomeVideoRemoteDataSource.kt
        │   ├── model
        │   │   ├── Image.kt
        │   │   ├── Post.kt
        │   │   ├── VideoDetails.kt
        │   │   └── VideoList.kt
        │   └── usecase
        │       └── HomeVideoUseCase.kt
        ├── repos
        │   ├── HomeVideoRepository.kt
        │   └── NetworkBoundResource.kt
        ├── ui
        │   ├── home
        │   │   ├── HomeFragment.kt
        │   │   ├── HomeViewModel.kt
        │   │   ├── HomeViewState.kt
        │   │   └── result
        │   │       ├── PostResultAdapter.kt
        │   │       └── PostResultViewModel.kt
        │   ├── main
        │   │   ├── MainActivity.kt
        │   │   └── MainActivityViewModel.kt
        │   └── splash
        │       ├── SplashFragment.kt
        │       └── SplashViewModel.kt
        └── utils
            ├── AppDebugTree.kt
            ├── AppGlideModule.kt
            ├── ContextExt.kt
            ├── UseCaseLiveData.kt
            ├── callbacks
            │   └── ActivityResultCallback.kt
            ├── domain
            │   ├── RateLimiter.kt
            │   ├── Resource.kt
            │   └── Status.kt
            └── extensions
                ├── GlideExt.kt
                ├── LiveDataExt.kt
                └── ViewExt.kt
```

## License
```
MIT License

Copyright (c) 2022 Shakil Ahmed Shaj

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
