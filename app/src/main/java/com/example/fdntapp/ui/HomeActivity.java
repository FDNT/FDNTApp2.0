 package com.example.fdntapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fdntapp.R;
import com.example.fdntapp.abstractions.BaseActivity;
import com.example.fdntapp.databinding.ActivityHomeBinding;
import com.example.fdntapp.ui.abfdnt.AbfdntActivity;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected int getBottomNavigationMenuItemId() {
        return R.id.action_home;
    }

    @Override
    protected View getRootView() {
        ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

}