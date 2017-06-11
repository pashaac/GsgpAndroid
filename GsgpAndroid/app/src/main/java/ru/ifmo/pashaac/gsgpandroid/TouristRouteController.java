package ru.ifmo.pashaac.gsgpandroid;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ifmo.pashaac.gsgpandroid.entity.Attraction;


/**
 * Created by pavel on 11.06.17.
 */

public class TouristRouteController implements Callback<List<Attraction>> {

    private static final String SERVER_URL = "http://46.101.83.31:8080";

    private double lat;
    private double lng;
    private double time;

    private GoogleMap googleMap;

    private List<Marker> drawAttractions = new ArrayList<>();
    private Polyline polyline;

    public TouristRouteController(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TouristRouteAPI touristRouteAPI = retrofit.create(TouristRouteAPI.class);

        Call<List<Attraction>> call = touristRouteAPI.getTouristRoute(lat, lng, time);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Attraction>> call, Response<List<Attraction>> response) {
        if(response.isSuccessful()) {
            List<Attraction> attractions = response.body();
            PolylineOptions polylineOptions = new PolylineOptions().add(new LatLng(lat, lng));
            for (Attraction attraction : attractions) {
                drawAttractions.add(googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(attraction.getLocation().getLatitude(), attraction.getLocation().getLongitude()))
                        .title(attraction.getName())));
                polylineOptions.add(new LatLng(attraction.getLocation().getLatitude(), attraction.getLocation().getLongitude()));
            }
            polyline = googleMap.addPolyline(polylineOptions);
        } else {
            System.out.println(response.errorBody());
        }
    }

    public void reset() {
        for (Marker drawAttraction : drawAttractions) {
            drawAttraction.remove();
        }
        drawAttractions.clear();
        if (polyline != null) {
            polyline.remove();
            polyline = null;
        }
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public void onFailure(Call<List<Attraction>> call, Throwable t) {
        t.printStackTrace();
    }
}
