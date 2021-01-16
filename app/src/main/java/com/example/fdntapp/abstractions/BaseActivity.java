package com.example.fdntapp.abstractions;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdntapp.R;
import com.example.fdntapp.ui.HomeActivity;
import com.example.fdntapp.ui.LoginActivity;
import com.example.fdntapp.ui.abfdnt.AbfdntActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// Super class fot other activity classes
public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    protected BottomNavigationView btmNavView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootView());

        btmNavView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        btmNavView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // post Causes the function to be added to the message queue
        btmNavView.post(() -> {
            switch(item.getItemId()) {
                case R.id.action_home:
                    startActivity(new Intent(this, HomeActivity.class));
                    break;
                case R.id.action_login:
                    startActivity(new Intent(this, LoginActivity.class));
                    break;
                case R.id.action_abfdnt:
                    startActivity(new Intent(this, AbfdntActivity.class));
                    break;
            }
        });
        return false;
    }

    protected void updateNavigationBarState() {
        int actionID = getBottomNavigationMenuItemId();
        selectBottomNavigationBarItem(actionID);
    }

    private void selectBottomNavigationBarItem(int actionID) {
        MenuItem item = btmNavView.getMenu().findItem(actionID);
        item.setChecked(true);
    }

    protected abstract int getBottomNavigationMenuItemId(); // Which menu item is selected, change state of that item

    protected abstract View getRootView(); // which layout needs to display when clicked on tab
}
