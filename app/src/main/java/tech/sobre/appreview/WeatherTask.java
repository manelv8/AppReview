package tech.sobre.appreview;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import tech.sobre.appreview.models.City;
import tech.sobre.appreview.retrofit.RetrofitClientInstance;
import tech.sobre.appreview.retrofit.WeatherService;

public class WeatherTask extends AsyncTask<Void,Void,Void> {

    WeatherService api;
    Call<City> call;
    City city = null;
    public WeatherTask(String city){
        api = RetrofitClientInstance.getRetrofitInstance().create(WeatherService.class);
        call = api.getCityWeather(city+",br","922bf58bbd2d90a4094d9cbe0434b4b4");

    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            Response<City> response =  call.execute();
            if(response.errorBody() == null){
                city = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(city != null){
            Log.d("appRev",city.getName());
        }else{
            Log.d("appRev","nulo -->>");
        }

    }
}
