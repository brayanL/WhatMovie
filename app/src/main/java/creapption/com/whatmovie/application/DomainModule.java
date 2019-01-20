package creapption.com.whatmovie.application;

import android.content.Context;

import com.google.gson.GsonBuilder;

import creapption.com.whatmovie.BuildConfig;
import creapption.com.whatmovie.data.DataManager;
import creapption.com.whatmovie.data.remote.WhatMovieService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Contains all common object that will be provided to whole application.
 * */
@Module
public class DomainModule {

    /**
     * Provide Context Application.
     * @param application the new application, it replace to {@link creapption.com.whatmovie.main.MainActivity}
     * @return application context
     * */
    @Provides
    Context provideContext(WhatMovieApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    DataManager proviDataManager(WhatMovieService whatMovieService) {
        return new DataManager(whatMovieService);
    }

    /**
     * Make the settings for the request and response that will be made
     * to the web services.
     * @return WhatMovieService object instance
     * */
    @Provides
    WhatMovieService provideWhatMovieService() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        //set logging interceptor, to catch request and responses and show them on Android Logcat.
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        httpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor);

        OkHttpClient customOkHttpClient = httpClientBuilder.build();

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();

        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(customOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WhatMovieService.class);
    }
}
