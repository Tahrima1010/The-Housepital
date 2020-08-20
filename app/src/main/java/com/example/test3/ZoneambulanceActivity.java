package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZoneambulanceActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private List<String> listDataGroup;
    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoneambulance);
        // initializing the views
        initViews();
        // initializing the listeners
        initListeners();
        // initializing the objects
        initObjects();
        // preparing list data
        initListData();
    }
    /**
     * method to initialize the views
     */
    private void initViews() {
        expandableListView = findViewById(R.id.expandableListView);
    }
    /**
     * method to initialize the listeners
     */
    private void initListeners() {
        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expandableListViewAdapter.getChild(groupPosition, childPosition);
                Intent intent;
                switch (selected) {
                    case "Dhaka":
                        intent = new Intent(ZoneambulanceActivity.this, AmbulanceActivity.class);
                        startActivity(intent);
                        break;
                    case "Bhola":
                        intent = new Intent(ZoneambulanceActivity.this, ZoneambholaActivity.class);
                        startActivity(intent);
                        break;
                    case "Chittagong":
                        intent = new Intent(ZoneambulanceActivity.this, ZoneamchittagongActivity.class);
                        startActivity(intent);
                        break;
                    case "Sylhet":
                        intent = new Intent(ZoneambulanceActivity.this, ZoneamsylhetActivity.class);
                        startActivity(intent);
                        break;
                    case "Barisal":
                        intent = new Intent(ZoneambulanceActivity.this, ZoneambarisalActivity.class);
                        startActivity(intent);
                        break;




                }
                return true;

            }
        });
        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();
            }
        });
        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * method to initialize the objects
     */
    private void initObjects() {
        // initializing the list of groups
        listDataGroup = new ArrayList<>();//a resizable array elements can be added and removed from an ArrayList whenever user want.
        // initializing the list of child
        listDataChild = new HashMap<>();// stores the data in (Key, Value) pairs.can store string key,string value
        // initializing the adapter object
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listDataGroup, listDataChild);
        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);
    }
    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {
        // Adding group data
        listDataGroup.add(getString(R.string.text_zone));
        // array of strings
        String[] array;
        // list of zone
        List<String> zoneList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_zone);
        for (String item : array) {
            zoneList.add(item);
        }


        // Adding child data
        listDataChild.put(listDataGroup.get(0), zoneList);
        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();


    }

}
