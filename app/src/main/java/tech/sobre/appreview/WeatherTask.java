package tech.sobre.appreview;

import android.app.Activity;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    TextView tvTemp;
    ImageView imgTemp;
    Activity ctx;

    public WeatherTask(Activity ctx, TextView tvTemp, ImageView imgTemp, String city){
        api = RetrofitClientInstance.getRetrofitInstance().create(WeatherService.class);
        call = api.getCityWeather(city+",br","922bf58bbd2d90a4094d9cbe0434b4b4");
        this.ctx = ctx;
        this.tvTemp = tvTemp;
        this.imgTemp = imgTemp;
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
            tvTemp.setText(String.valueOf(city.getWeather().getTemp()));
            Picasso.get().load("http://openweathermap.org/img/w/"+city.getWeatherConditions()[0].getIcon()+".png").into(imgTemp);
        }else{
            Log.d("appRev","nulo -->>");
        }

    }
}
