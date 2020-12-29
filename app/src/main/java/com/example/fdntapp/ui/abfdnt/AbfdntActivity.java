package com.example.fdntapp.ui.abfdnt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.ActivityAbfdntBinding;
import com.example.fdntapp.ui.LoginActivity;
import com.example.fdntapp.ui.HomeActivity;
import com.google.android.material.navigation.NavigationView;

public class AbfdntActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityAbfdntBinding binding;
    NavController navController;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAbfdntBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //navigation between activities
        binding.bottomNavView.setSelectedItemId(R.id.navigation_abfdnt);
        binding.bottomNavView.setOnNavigationItemSelectedListener(item-> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    break;
                case R.id.navigation_login:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    break;
                default:
                    return false;
            }
            return false;
        });

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //drawer navigation
        setSupportActionBar(binding.abfdntToolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.abfdntToolbar,
                R.string.open_string, R.string.close_string);
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // on click item of navigation drawer
        binding.abFdntDrawer.setNavigationItemSelectedListener(this);
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
            case R.id.about:
                navController.navigate(R.id.aboutFragment);
                break;
            case R.id.our_patron:
                navController.navigate(R.id.patronFragment);
                break;
        }
        return false;
    }
}