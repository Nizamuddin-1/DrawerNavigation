package com.example.drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
NavigationView navigationView;
DrawerLayout drawerLayout;
Toolbar  toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView= findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.optNotes)
                {
                    loadfra(new A(),0);
                }
                else if(id ==R.id.optHome)
                {
                    loadfra(new B(),1);
                }
                else
                {
                    loadfra(new C(),1);
                }
                return true;
            }
        });
    }
    public void loadfra(Fragment fragment,int flag)
    {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        if(flag==0)
        {
            ft.add(R.id.container,fragment);
        }
        else
        {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}