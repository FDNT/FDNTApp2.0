package com.example.android.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.R;
import com.example.android.abstractions.BaseActivity;
import com.example.android.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        System.out.println(mAuth);
        binding.logInButton.setOnClickListener(view -> {
            String email = binding.logInName.getText().toString();
            String password = binding.logInPassword.getText().toString();
            LoggingTask(email, password);
        });
    }

    private void LoggingTask(String email, String password) {

        System.out.println(email);
        System.out.println(password);

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Nie podano danych", Toast.LENGTH_SHORT).show();
        }
        else mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(LoginActivity.this, "Logowanie się powiodło", Toast.LENGTH_SHORT).show();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Logowanie nie udało się",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        binding.bottomNavView.getRoot().getMenu().clear();
        binding.bottomNavView.getRoot().inflateMenu(R.menu.main_menu_logged_in);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }



    @Override
    protected int getBottomNavigationMenuItemId() {
        return R.id.action_login;
    }

    @Override
    protected View getRootView() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

}