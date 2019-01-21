package creapption.com.whatmovie.data.remote;

import java.io.IOException;

import creapption.com.whatmovie.util.Constants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Add Query Parameter to every request, the which correspond to api_key
 * provided for TheMovieDB.
 * */
public class AddParameterInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", Constants.API_KEY)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        return chain.proceed(requestBuilder.build());
    }
}
