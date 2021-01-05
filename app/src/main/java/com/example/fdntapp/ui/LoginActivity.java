package com.example.fdntapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.ActivityLoginBinding;
import com.example.fdntapp.ui.abfdnt.AbfdntActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        mAuth = FirebaseAuth.getInstance();

        setContentView(view);

        binding.bottomNavView.setSelectedItemId(R.id.navigation_login);
        binding.bottomNavView.setOnNavigationItemSelectedListener(item-> {
            switch(item.getItemId()) {
                case R.id.navigation_abfdnt:
                    startActivity(new Intent(this, AbfdntActivity.class));
                    break;
                case R.id.navigation_home:
                    startActivity(new Intent(this, HomeActivity.class));
                    break;
                default:
                    return false;
            }
            return false;
        });
        binding.logInButton.setOnClickListener(this);
    }

    private void startLogging() {
        String email = binding.logInName.getText().toString();
        String password = binding.logInName.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
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
    public void onClick(View v) {
        if (v.getId() == R.id.log_in_button) {
            startLogging();
            System.out.println("XD");
        }
    }
}