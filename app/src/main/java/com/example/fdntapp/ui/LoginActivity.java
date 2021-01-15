package com.example.fdntapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fdntapp.R;
import com.example.fdntapp.abstractions.BaseActivity;
import com.example.fdntapp.databinding.ActivityLoginBinding;
import com.example.fdntapp.ui.abfdnt.AbfdntActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        binding.logInButton.setOnClickListener(view -> {
            String email = binding.logInName.getText().toString();
            String password = binding.logInName.getText().toString();
            LoggingTask(email, password);
        });
    }

    private void LoggingTask(String email, String password) {

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Nie podano danych", Toast.LENGTH_SHORT).show();
        }
        else mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(LoginActivity.this, "Logowanie się powiodło", Toast.LENGTH_SHORT).show();
                        // updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Logowanie nie udało się",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // TODO: updateUI(currentUser);
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