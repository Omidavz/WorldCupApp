package com.example.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    private static CustomAdapter adapter ;
    ArrayList<CountryModelClass> datamodels ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        datamodels = new ArrayList<>() ;
        datamodels.add(new CountryModelClass("Brazil","5",R.drawable.brazil));
        datamodels.add(new CountryModelClass("Germany","4",R.drawable.germany));
        datamodels.add(new CountryModelClass("France","2",R.drawable.france));
        datamodels.add(new CountryModelClass("Spain","1",R.drawable.spain));
        datamodels.add(new CountryModelClass("England","1",R.drawable.unitedkingdom));
        datamodels.add(new CountryModelClass("United States","0",R.drawable.unitedstates));
        datamodels.add(new CountryModelClass("Saudi Arabia","0",R.drawable.saudiarabia));


        adapter = new CustomAdapter(datamodels,this);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Country " +adapter.getItem(position).getCountry_name()
                        +"\n" +"World Cups wins: "+ adapter.getItem(position).getCup_win_count(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}