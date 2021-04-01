package com.example.bordeauxien_restaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Valley Pinot Noir", getString(R.string.pinotnoir), R.drawable.pinotnoir ));
        modelList.add(new Model("Red Blend", getString(R.string.redblend), R.drawable.redblend));
        modelList.add(new Model("Cabernet Franc", getString(R.string.cabernetfranc), R.drawable.cabernetfranc));
        modelList.add(new Model("Cabernet Sauvignon", getString(R.string.sauvignon), R.drawable.sauvignon));
        modelList.add(new Model("Brut Cuvee", getString(R.string.brutcuvee), R.drawable.brutcuvee));
        modelList.add(new Model("Pinot Gris", getString(R.string.pinotgris), R.drawable.pinotgris));
        modelList.add(new Model("Northwest Riesling", getString(R.string.riesling), R.drawable.riesling));
        modelList.add(new Model("Blanc De Noir", getString(R.string.blancdenoir), R.drawable.blancdenoir));
        modelList.add(new Model("Cuvee Blanc", getString(R.string.cuveeblanc), R.drawable.cuveeblanc));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);




    }
}