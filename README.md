# WhatMovie
App that consume TheMovieDB Api. [Details](https://developers.themoviedb.org/4/getting-started/authorization)

Shows movies in three categories: Popular, Top Rated and Upcoming.

1. This project follows the MVP architecture, as describe bellow: [MVP Arquitecture](https://github.com/ribot/android-guidelines/blob/master/architecture_guidelines/android_architecture.md).
![alt text](https://raw.githubusercontent.com/ribot/android-guidelines/master/architecture_guidelines/architecture_diagram.png)

2. Working with Android Guidelines used by Ribot: [Android Guidlines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md)

**Answers.**
**1. What is the Single Responsibility Principle?**
The Single Responsibility Principle helps us to ensure that each class meets a single responsibility. In the project we achieve this by using MVP, thus having three capable and delegating responsibility to each layer, making the code more testable and maintainable.

**2. What features has a good code?**
A clean code has many details one of them is that it can be understood by just reading it for it should not be used abbreviations. Another detail is not to repeat code this is a terrible practice. Another important part is to divide the code into small parts, in this way it is more understandable and more maintainable.

In this project we use the following libraries.
⋅⋅* [Dagger 2](https://github.com/google/dagger)
⋅⋅* [RxJava 2](https://github.com/ReactiveX/RxAndroid)
⋅⋅* [Okhttp](https://github.com/square/okhttp) 
⋅⋅* [Retrofit](https://github.com/square/retrofit)
⋅⋅* [ButterKnife](https://github.com/JakeWharton/butterknife)
⋅⋅* [Glide](https://github.com/bumptech/glide)
