package tech.sobre.appreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import tech.sobre.appreview.adapters.CitiesAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button btnAdd;
    ArrayList<String> citiesList;
    CitiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        String[] array = getResources().getStringArray(R.array.citiesArray);

        citiesList  = new ArrayList<String>( Arrays.asList(array));

        adapter = new CitiesAdapter(this,citiesList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name = citiesList.get(position);

//                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),DetailActivity.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });


    }
}
