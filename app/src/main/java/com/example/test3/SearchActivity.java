package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        androidx.appcompat.widget.Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // ActionBar actionBar=getSupportActionBar();
        setTitle("Item List");


        title=new String[]{"Heart Failure","Jondish","kidney cancer","Migraine","Allergies","Corona Virus(Covid-19)","Chicken Pox","Diabetes","Diarrhoea","Ebola Virus Diseases","Eye Cancer","Food Poisoning","Liver Cancer","Malaria","Malnutrition","Itching","HIV","Headaches","Hepatitis A,B,C"};
        description=new String[]{"Heart Failure details...","Jondish details...","kidney cancer details...","Migraine details...","Allergies details...","Corona Virus(Covid-19) details...","Chicken Pox details...","Diabetes details...","Diarrhoea details...","Ebola Virus Diseases details...","Eye Cancer details...","Food Poisoning details...","Liver Cancer details...","Malaria details...","Malnutrition details...","Itching details...","HIV details...","Headaches details...","Hepatitis A,B,C details..."};
        icon=new int[]{R.drawable.heartfailure,R.drawable.jondish,R.drawable.kidneycnacer,R.drawable.migrane,R.drawable.allergies,R.drawable.coronavirus,R.drawable.chickenpox,R.drawable.diabetes,R.drawable.diarrhea,R.drawable.ebolavirus,R.drawable.eyecancer,R.drawable.foodpoisoning,R.drawable.livercancer,R.drawable.malaria,R.drawable.malnutrition,R.drawable.itching,R.drawable.hiv,R.drawable.headaches,R.drawable.hepatitis};

        listView= findViewById(R.id.listView) ;
        for(int i=0 ; i<title.length;i++)
        {
            Model model=new Model(title[i],description[i],icon[i]);
            //bind all string in an array
            arrayList.add(model);

        }
        //pass result to list view adapter class
        adapter=new ListViewAdapter(this,arrayList);
        //bind the adapter in a list view
        listView.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.manu_layout,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s))
                {
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else
                {
                    adapter.filter(s);
                }
                return true;
            }




        });

        return true;
    }


   /* public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manu_layout,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        // Get the SearchView and set the searchableview configuration
        SearchView searchView=(SearchView) myActionMenuItem.getActionView();//direct access paoar jnno
        //Callbacks for changes to the query text.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s))
                {
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else
                {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }*/

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId()==R.id.signoutmenuid)
       {
           FirebaseAuth.getInstance().signOut();
           finish();
           Intent intent =new Intent(getApplicationContext(),MainActivity.class);
           startActivity(intent);

       }

       return super.onOptionsItemSelected(item);
   }
}


