package com.example.fdntapp;

import android.os.Bundle;
import android.view.View;

import com.example.fdntapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        /*
        * Passing each menu ID as a set of Ids because each
        * menu should be considered as top level destinations.
        */
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_login, R.id.navigation_abfdnt)
                .build();
        /*
        * Navigating to a destination is done using a NavController, an object that manages app navigation within a NavHost.
        * Each NavHost has its own corresponding NavController.
        * NavHost is an empty container where destinations are swapped in and out as a user navigates through your app.
        * NavHostFragment is an default NavHost implementation
        */
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}