package com.example.fdntapp.ui.abfdnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.FragmentPatronBinding;

import org.jetbrains.annotations.NotNull;

public class PatronFragment extends Fragment {
    FragmentPatronBinding binding;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPatronBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
