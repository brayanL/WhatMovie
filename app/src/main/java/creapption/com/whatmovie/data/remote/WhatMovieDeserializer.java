package creapption.com.whatmovie.data.remote;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import creapption.com.whatmovie.data.remote.api.MovieByIdResponseModel;


/**
 * Deserializer for get information of Movie Detail. Allows you to select
 * specific data and return them to the response.
 * */
public class WhatMovieDeserializer implements JsonDeserializer<MovieByIdResponseModel> {

    @Override
    public MovieByIdResponseModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        Log.i("TAG", "deserialize: " + jsonObject);

        MovieByIdResponseModel movieDetail = new MovieByIdResponseModel();
        movieDetail.setId(jsonObject.get("id").getAsLong());
        movieDetail.setHomepage(jsonObject.get("homepage").toString());
        movieDetail.setVideos(new Gson()
                .fromJson(jsonObject.get("videos").getAsJsonObject().get("results").getAsJsonArray(),
                        new TypeToken<List<MovieByIdResponseModel.Video>>(){}.getType()));
        movieDetail.setCast(new Gson()
                .fromJson(jsonObject.get("credits").getAsJsonObject().get("cast").getAsJsonArray(),
                        new TypeToken<List<MovieByIdResponseModel.Cast>>(){}.getType()));
        return movieDetail;
    }
}
