package com.example.sakshi.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;         //declaring object for list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.displaylist);       //associating list view
        ArrayList<String> arrayList = new ArrayList<>();                //creating arraylist
        for(int i=0;i<5;i++){
            arrayList.add("Item "+i);               //adding data into array list
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        mListView.setAdapter(arrayAdapter);
        registerForContextMenu(mListView);          //registering context menu for list view

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //method for creating context menu
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");        //setting title for the context menu0
        menu.add(0,1,1,"Action 1");             //adding sub menus
        menu.add(0,2,2,"Action 2");
        menu.add(0,3,3,"Action 3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //method for item selection
        if(item.getGroupId()==0 && item.getItemId()==1){
            //toast for when action 1 is clicked
            Toast.makeText(this, "Action 1 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getGroupId()==0 && item.getItemId()==2){
            //toast for when action 2 is clicked
            Toast.makeText(this, "Action 2 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getGroupId()==0 && item.getItemId()==3){
            //toast for when action 3 is clicked
            Toast.makeText(this, "Action 3 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}
