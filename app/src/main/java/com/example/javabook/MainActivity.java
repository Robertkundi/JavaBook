package com.example.javabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG="MainActivity";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
private Context context;
ArrayList<String> titleArrayList;
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        context = MainActivity.this;
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.WHAT_IS_JAVA);
        titleArrayList.add(Constants.HISTORY_OF_JAVA);
        titleArrayList.add(Constants.FEATURES_OF_JAVA);
        titleArrayList.add(Constants.C_VS_JAVA);
        titleArrayList.add(Constants.HELLO_JAVA_PROGRAM);
        titleArrayList.add(Constants.PROGRAM_INTERNAL);
        titleArrayList.add(Constants.HOW_TO_SET_PATH);
        titleArrayList.add(Constants.JDK_JRE_AND_JVM);
        titleArrayList.add(Constants.INTERNAL_DETAIL_OF_JVM);
        titleArrayList.add(Constants.JAVA_VARIABLES);
        titleArrayList.add(Constants.JAVA_DATA_TYPE);
        titleArrayList.add(Constants.UNICODE_SYSTEM);
        titleArrayList.add(Constants.OPERATORS);


        recyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TitleAdapter adapter = new TitleAdapter(context, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent= new Intent(context,DescriptionActivity.class);
                intent.putExtra("titles", titleArrayList.get(position));
                startActivity(intent);

                Toast.makeText(context, "clicked"+titleArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

// codes for navigation drawer

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView= (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =item.getItemId();
                if (id==R.id.myprofile)
                {
                    Toast.makeText(MainActivity.this, "my profile ", Toast.LENGTH_SHORT).show();

                }
                else if (id==R.id.setings)
                {
                    Toast.makeText(MainActivity.this, " my settiing ", Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.editprofile)
                {
                    Toast.makeText(MainActivity.this, " edit profile", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return toggle.onOptionsItemSelected(item) ||super.onOptionsItemSelected(item);
    }

    }

