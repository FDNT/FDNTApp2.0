package com.example.fdntapp;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import com.example.fdntapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
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

        //bottom navigation
        binding.drawerNavView.getMenu().clear();
        binding.drawerNavView.inflateMenu(R.menu.bottom_nav_menu);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        binding.bottomNavView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    navController.navigate(R.id.navigation_home);
                    binding.drawerNavView.getMenu().clear();
                    binding.drawerNavView.inflateMenu(R.menu.home_menu);
                    break;
                case R.id.navigation_login:
                    navController.navigate(R.id.navigation_login);
                    binding.drawerNavView.getMenu().clear();
                    break;
                case R.id.navigation_abfdnt:
                    navController.navigate(R.id.navigation_abfdnt);
                    binding.drawerNavView.getMenu().clear();
                    binding.drawerNavView.inflateMenu(R.menu.abfdnt_menu);
                    break;
            }
            return false;
        });

            //drawer
            setSupportActionBar(binding.toolbar);
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
                    R.string.open_string, R.string.close_string);
            binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);

            // on click item of navigation drawer
            binding.drawerNavView.setNavigationItemSelectedListener(item -> {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            });
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}