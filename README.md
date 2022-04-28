### Directory Structure

The following is a high level overview of relevant files and folders.

```
Easy T3ch - Hilt - MVVM
.
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