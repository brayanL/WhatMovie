package creapption.com.whatmovie.main.di;

import javax.inject.Singleton;

import creapption.com.whatmovie.application.WhatMovieApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, BuildersModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(WhatMovieApplication application);
        AppComponent build();
    }
    void inject(WhatMovieApplication albumsApplication);
}
