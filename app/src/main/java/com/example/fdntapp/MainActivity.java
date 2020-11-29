package com.example.fdntapp;

import android.content.ClipData;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import com.example.fdntapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        NavController navController = Navigation.findNavController(this,  R.id.nav_host_fragment);
        navController.setGraph(R.navigation.mobile_navigation);

        //bottom navigation, and changing menu of drawer, which changes depending on the current tab
        changeMenu(binding.drawerNavView, R.menu.home_menu);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        binding.bottomNavView.setOnNavigationItemSelectedListener(item ->
                onBottomNavigationItemSelectedListener(item, navController, binding.bottomNavView, binding.drawerNavView)
        );

            //drawer
        setSupportActionBar(binding.toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
                R.string.open_string, R.string.close_string);
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);

        // on click item of navigation drawer
        binding.drawerNavView.setNavigationItemSelectedListener(item ->
                onDrawerNavigationItemSelectedListener(item, navController, binding.drawerLayout, binding.drawerNavView)
        );
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    protected void changeMenu(NavigationView navigationView, int MenuID) {
        navigationView.getMenu().clear();
        navigationView.inflateMenu(MenuID);
    }

    protected boolean onBottomNavigationItemSelectedListener(MenuItem item, NavController navController,
                                                             BottomNavigationView navigationView, NavigationView drawerNavigationView) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                navController.navigate(R.id.navigation_home);
                changeMenu(drawerNavigationView, R.menu.home_menu);
                break;
            case R.id.navigation_login:
                navController.navigate(R.id.navigation_login);
                drawerNavigationView.getMenu().clear();
                break;
            case R.id.navigation_abfdnt:
                navController.navigate(R.id.navigation_abfdnt);
                changeMenu(drawerNavigationView, R.menu.abfdnt_menu);
                break;
        }
        return false;
    }

    protected boolean onDrawerNavigationItemSelectedListener(MenuItem item, NavController navController, DrawerLayout drawerLayout, NavigationView navigationView) {
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}