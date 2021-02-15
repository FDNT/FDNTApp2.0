package com.example.android;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

public class Util {
    public static boolean is_logged_in() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }
}
