package com.example.fdntapp.ui.abfdnt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.FragmentAbfdntBinding;

public class AbFdntFragment extends Fragment {

    private FragmentAbfdntBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAbfdntBinding.inflate(getLayoutInflater());
        AbFdntViewModel abFdntViewModel = new ViewModelProvider(this).get(AbFdntViewModel.class);

        return binding.getRoot();
    }
}