package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
public class ListItems extends AppCompatActivity {


        ListView simpleList;
        String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
        int flags[] = {R.drawable.india_96px, R.drawable.pagoda_96px, R.drawable.america_60px, R.drawable.cristiano_ronaldo_96px, R.drawable.usa_96px, R.drawable.america_60px};


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_items);
            simpleList = (ListView) findViewById(R.id.simpleListView);
            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
            simpleList.setAdapter(customAdapter);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.menu_items,menu);
        return true;
    }

        /*  public boolean onCreateOptionsMenu (Menu menu){
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(menu, menu);
                return true;

        }*/
    }

