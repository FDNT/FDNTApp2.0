 package com.example.android.ui;

import android.view.View;

import com.example.android.R;
import com.example.android.abstractions.BaseActivity;
import com.example.android.databinding.ActivityHomeBinding;

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