package com.shajitha.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CheckList extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.rView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        List<ChecklistItems> items = new ArrayList<>();

        // pass the arguments
        items.add(new ChecklistItems(ChecklistItems.imageLayout,R.drawable.winter,"Winter Checklist"));

        items.add(new ChecklistItems(ChecklistItems.listLayout, "Winter boots"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Thermal wear"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Cardigan/Winter coat"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Sleepwear"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Scarfs"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Gloves"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Ear muffs"));


        items.add(new ChecklistItems(ChecklistItems.imageLayout,R.drawable.done, "Summer Checklist"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Sunscreen/sunblock"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Packing cubes"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Exercise/Active time"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Swimsuits"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Boots/Sports shoe"));


        items.add(new ChecklistItems(ChecklistItems.imageLayout,R.drawable.firstaidkit, "FirstAid kit Checklist"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Medication"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Lip balm"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Instant cold ice packs"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Antiseptic wipes"));
        items.add(new ChecklistItems(ChecklistItems.listLayout, "Adhesive plasters large/small"));


        ChecklistAdapter adapter = new ChecklistAdapter(items);

        recyclerView.setAdapter(adapter);
    }
}