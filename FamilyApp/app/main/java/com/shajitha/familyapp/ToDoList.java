package com.shajitha.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ToDoList extends AppCompatActivity {
ArrayList<String> itemList;
ArrayAdapter<String> adapter;
EditText itemInput;
Button addItem;
ListView list;

    final Handler handler = new Handler();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        getSupportActionBar().hide();

        itemInput = findViewById(R.id.items);
        addItem = findViewById(R.id.addButton);

        list = findViewById(R.id.Listitems);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,itemList);

        View.OnClickListener addlistener = new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if( itemInput.getText().toString().isEmpty()) {
                    itemInput.setHint("Please Enter Item...");
                  }
                else{
                    itemList.add(itemInput.getText().toString());
                    itemInput.setText("");
                    adapter.notifyDataSetChanged();
                    itemInput.setHint("Add Items...");
                    }
            }
        };


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) itemList.get(position);

                list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                list.setItemChecked(position, true);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        adapter.remove(value);
                        adapter.notifyDataSetChanged();
                        list.setItemChecked(position, false);

                    }
                }, 1000);
            }
        });

        addItem.setOnClickListener(addlistener);
        list.setAdapter(adapter);
     //   list.setChoiceMode(ListView.CHOICE_MODE_NONE);
    }
}