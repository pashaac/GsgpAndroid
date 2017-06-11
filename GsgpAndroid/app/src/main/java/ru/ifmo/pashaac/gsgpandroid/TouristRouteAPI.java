package ru.ifmo.pashaac.gsgpandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.ifmo.pashaac.gsgpandroid.entity.Attraction;

/**
 * Created by pavel on 11.06.17.
 */

public interface TouristRouteAPI {
    @GET("route/attraction")
    Call<List<Attraction>> getTouristRoute(@Query("lat") double lat, @Query("lng") double lng, @Query("time") double time);
}
