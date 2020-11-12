package com.example.fdntapp;

import android.os.Bundle;
import android.view.View;

import com.example.fdntapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
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

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_login, R.id.navigation_abfdnt)
                .build();

        // i had to this because i used FragmentContainerView instead of fragment to implement navhost
        // https://issuetracker.google.com/issues/142847973
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        //
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}