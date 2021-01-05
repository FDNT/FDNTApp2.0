package com.example.fdntapp.ui.abfdnt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.ActivityAbfdntBinding;
import com.example.fdntapp.ui.LoginActivity;
import com.example.fdntapp.ui.HomeActivity;
import com.google.android.material.navigation.NavigationView;

public class AbfdntActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityAbfdntBinding binding;
    NavController navController;
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
                    startActivity(new Intent(this, HomeActivity.class));
                    break;
                case R.id.navigation_login:
                    startActivity(new Intent(this, LoginActivity.class));
                    break;
                default:
                    return false;
            }
            return false;
        });

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //drawer navigation
        setSupportActionBar(binding.abfdntToolbar);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.about_fragment, R.id.patron_fragment)
                .setOpenableLayout(binding.drawerLayout)
                .build();
        NavigationUI.setupWithNavController(binding.abfdntToolbar, navController, appBarConfiguration);

        // on click item of navigation drawer
        binding.drawerNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.about_fragment:
                navController.navigate(R.id.about_fragment);
                break;
            case R.id.patron_fragment:
                navController.navigate(R.id.patron_fragment);
                break;
        }
        return false;
    }
}