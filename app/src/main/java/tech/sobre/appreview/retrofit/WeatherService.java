package tech.sobre.appreview.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tech.sobre.appreview.models.City;

public interface WeatherService {

    @GET("weather")
    Call<City> getCityWeather(@Query("q") String city,
                              @Query("apikey") String api);
}
