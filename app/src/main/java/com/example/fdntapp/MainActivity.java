package com.example.fdntapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.fdntapp.databinding.ActivityMainBinding;
import com.example.fdntapp.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavController navBottomController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // i had to this because i used FragmentContainerView instead of fragment to implement navhost
        // https://issuetracker.google.com/issues/142847973
        NavHostFragment navBottomHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navBottomController = navBottomHostFragment.getNavController();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navBottomController.getGraph()).build();
        NavigationUI.setupWithNavController(binding.navView, navBottomController);

        setSupportActionBar(binding.toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
                R.string.open_string, R.string.close_string);
        binding.navDrawerView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.navigation_home:
                navBottomController.navigate(R.id.navigation_home);
                break;
            case R.id.navigation_login:
                navBottomController.navigate(R.id.navigation_login);
                break;
            case R.id.navigation_abfdnt:
                navBottomController.navigate(R.id.navigation_abfdnt);
                break;
        }
        return true;
    }
}