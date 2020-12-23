package com.example.fdntapp.ui.abfdnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.ActivityAbfdntBinding;
import com.example.fdntapp.ui.LoginActivity;
import com.example.fdntapp.ui.home.HomeActivity;

public class AbfdntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAbfdntBinding binding = ActivityAbfdntBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

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
    }
}