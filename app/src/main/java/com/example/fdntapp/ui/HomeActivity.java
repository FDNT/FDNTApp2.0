 package com.example.fdntapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.ActivityHomeBinding;
import com.example.fdntapp.ui.abfdnt.AbfdntActivity;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.bottomNavView.setSelectedItemId(R.id.navigation_home);
        binding.bottomNavView.setOnNavigationItemSelectedListener(item-> {
            switch(item.getItemId()) {
                case R.id.navigation_abfdnt:
                    startActivity(new Intent(this, AbfdntActivity.class));
                    finish();
                    break;
                case R.id.navigation_login:
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                    break;
                default:
                    return false;
            }
            return false;
        });
    }
    
}