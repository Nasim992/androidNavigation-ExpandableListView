package com.example.navigationbarapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
//    Global variable Declaration
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

//    Expandable List View
    ExpandableListView expandableListViewExample;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableTitleList;
    HashMap<String, List<String>> expandableDetailList;

//    Expandable recycler View

    private RecyclerView recyclerView;
    private List<DataModel> mList;
    private ItemAdapter adapter;



    //  Drawer Toggle Options
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
            return super.onOptionsItemSelected(item);
    }

//    Main Activity Functions
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Expandable Recycler View Starts

        recyclerView = findViewById(R.id.main_recyclervie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        //list1
        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("Jams and Honey");
        nestedList1.add("Pickles and Chutneys");
        nestedList1.add("Readymade Meals");
        nestedList1.add("Chyawanprash and Health Foods");
        nestedList1.add("Pasta and Soups");
        nestedList1.add("Sauces and Ketchup");
        nestedList1.add("Namkeen and Snacks");
        nestedList1.add("Honey and Spreads");

        List<String> nestedList2 = new ArrayList<>();
        nestedList2.add("Book");
        nestedList2.add("Pen");
        nestedList2.add("Office Chair");
        nestedList2.add("Pencil");
        nestedList2.add("Eraser");
        nestedList2.add("NoteBook");
        nestedList2.add("Map");
        nestedList2.add("Office Table");

        List<String> nestedList3 = new ArrayList<>();
        nestedList3.add("Decorates");
        nestedList3.add("Tea Table");
        nestedList3.add("Wall Paint");
        nestedList3.add("Furniture");
        nestedList3.add("Bedsits");
        nestedList3.add("Certain");
        nestedList3.add("Namkeen and Snacks");
        nestedList3.add("Honey and Spreads");

        List<String> nestedList4 = new ArrayList<>();
        nestedList4.add("Pasta");
        nestedList4.add("Spices");
        nestedList4.add("Salt");
        nestedList4.add("Chyawanprash");
        nestedList4.add("Maggie");
        nestedList4.add("Sauces and Ketchup");
        nestedList4.add("Snacks");
        nestedList4.add("Kurkure");

        List<String> nestedList5 = new ArrayList<>();
        nestedList5.add("Jams and Honey");
        nestedList5.add("Pickles and Chutneys");
        nestedList5.add("Readymade Meals");
        nestedList5.add("Chyawanprash and Health Foods");
        nestedList5.add("Pasta and Soups");
        nestedList5.add("Sauces and Ketchup");
        nestedList5.add("Namkeen and Snacks");
        nestedList5.add("Honey and Spreads");

        List<String> nestedList6 = new ArrayList<>();
        nestedList6.add("Pasta");
        nestedList6.add("Spices");
        nestedList6.add("Salt");
        nestedList6.add("Chyawanprash");
        nestedList6.add("Maggie");
        nestedList6.add("Sauces and Ketchup");
        nestedList6.add("Snacks");
        nestedList6.add("Kurkure");


        List<String> nestedList7 = new ArrayList<>();
        nestedList7.add("Decorates");
        nestedList7.add("Tea Table");
        nestedList7.add("Wall Paint");
        nestedList7.add("Furniture");
        nestedList7.add("Bedsits");
        nestedList7.add("Certain");
        nestedList7.add("Namkeen and Snacks");
        nestedList7.add("Honey and Spreads");
        List<String> nestedList8 = new ArrayList<>();

        mList.add(new DataModel(nestedList1 , "Instant Food and Noodles"));
        mList.add(new DataModel( nestedList2,"Stationary"));
        mList.add(new DataModel( nestedList3,"Home Care"));
        mList.add(new DataModel(nestedList4 ,"Grocery & Staples"));
        mList.add(new DataModel(nestedList5,"Pet Care"));
        mList.add(new DataModel(nestedList6,"Baby Care"));
        mList.add(new DataModel(nestedList7 ,"Personal Care"));
        mList.add(new DataModel(nestedList8,"Test Added"));

        adapter = new ItemAdapter(mList);
        recyclerView.setAdapter(adapter);
//        Expandable Recycler View Ends


//        Get Layout On Find by Activity
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);

//        Expandable List View
        expandableListViewExample = (ExpandableListView) findViewById(R.id.expandableListViewSample);
        expandableDetailList = ExpandableListDataItems.getData();
        expandableTitleList = new ArrayList<String>(expandableDetailList.keySet());
        expandableListAdapter = new CustomizedExpandableListAdapter(this, expandableTitleList, expandableDetailList);
        expandableListViewExample.setAdapter(expandableListAdapter);

        // This method is called when the group is expanded
        expandableListViewExample.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableTitleList.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the group is collapsed
        expandableListViewExample.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableTitleList.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
            }
        });
//
        if(expandableListViewExample.getChildCount()<=0){
            expandableListViewExample.setGroupIndicator(null);
        }
        Log.d("error",expandableListViewExample.toString());
        // This method is called when the child in any group is clicked
        // via a toast method, it is shown to display the selected child item as a sample
        // we may need to add further steps according to the requirements
        expandableListViewExample.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), expandableTitleList.get(groupPosition)
                        + " -> "
                        + expandableDetailList.get(
                        expandableTitleList.get(groupPosition)).get(
                        childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });


        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavigationView nv= (NavigationView) findViewById(R.id.nav_view);
                Menu m=nv.getMenu();

                switch(item.getItemId()){
                    case R.id.home: {
                        Toast.makeText(MainActivity.this,"Home Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.contact: {
                        Toast.makeText(MainActivity.this,"Contact Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.gallery: {
                        Toast.makeText(MainActivity.this,"Gallery Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.about: {
                        Toast.makeText(MainActivity.this,"About Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.login: {
                        Toast.makeText(MainActivity.this,"Login Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.share: {
                        Toast.makeText(MainActivity.this,"Share Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.rate_us: {
                        Toast.makeText(MainActivity.this,"Rate Us Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return false;
            }
        });
    }

//    Back Function When Pressing
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}