package com.example.android.abstractions;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.R;
import com.example.android.ui.HomeActivity;
import com.example.android.ui.LoginActivity;
import com.example.android.ui.abfdnt.AbfdntActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.android.Util.is_logged_in;

// Super class fot other activity classes
public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    protected BottomNavigationView btmNavView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootView());

        btmNavView = findViewById(R.id.bottom_nav_view);

        if (is_logged_in()) {
            btmNavView.getMenu().clear();
            btmNavView.inflateMenu(R.menu.main_menu_logged_in);
        }

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
