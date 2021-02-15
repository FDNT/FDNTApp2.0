package com.example.android.ui.abfdnt;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.android.R;
import com.example.android.abstractions.BaseActivity;
import com.example.android.databinding.ActivityAbfdntBinding;

public class AbfdntActivity extends BaseActivity {
    private ActivityAbfdntBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //drawer navigation
        setSupportActionBar(binding.abfdntToolbar);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.about_fragment, R.id.patron_fragment)
                .setOpenableLayout(binding.drawerLayout)
                .build();
        NavigationUI.setupWithNavController(binding.abfdntToolbar, navController, appBarConfiguration);

        // on click item of navigation drawer
        binding.drawerNavView.setNavigationItemSelectedListener(item -> {
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
        });
    }

    @Override
    protected int getBottomNavigationMenuItemId() {
        return R.id.action_abfdnt;
    }

    @Override
    protected View getRootView() {
        binding = ActivityAbfdntBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}