package tech.sobre.appreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {

    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent args = getIntent();

        if(args != null){
            cityName = args.getStringExtra("name");
            Log.d("appreview",cityName);
        }

        WeatherTask task = new WeatherTask(cityName);
        task.execute();

    }
}
