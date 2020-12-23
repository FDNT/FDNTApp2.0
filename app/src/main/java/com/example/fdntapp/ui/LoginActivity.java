package com.example.fdntapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.ActivityLoginBinding;
import com.example.fdntapp.ui.abfdnt.AbfdntActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.bottomNavView.setSelectedItemId(R.id.navigation_login);
        binding.bottomNavView.setOnNavigationItemSelectedListener(item-> {
            switch(item.getItemId()) {
                case R.id.navigation_abfdnt:
                    startActivity(new Intent(getApplicationContext(), AbfdntActivity.class));
                    break;
                case R.id.navigation_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    break;
                default:
                    return false;
            }
            return false;
        });
    }

}