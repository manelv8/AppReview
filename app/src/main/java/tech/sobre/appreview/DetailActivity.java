package tech.sobre.appreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    String cityName;
    TextView tvTemp;
    ImageView imgTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTemp = findViewById(R.id.tvTemp);
        imgTemp = findViewById(R.id.imgTemp);

        Intent args = getIntent();

        if(args != null){
            cityName = args.getStringExtra("name");
            Log.d("appreview",cityName);
        }

        WeatherTask task = new WeatherTask(this,tvTemp, imgTemp,cityName);
        task.execute();

    }
}
