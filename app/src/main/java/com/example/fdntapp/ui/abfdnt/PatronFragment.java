package com.example.fdntapp.ui.abfdnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.FragmentPatronBinding;

public class PatronFragment extends Fragment {
    FragmentPatronBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPatronBinding.inflate(inflater, container, false);
        setTexts();
        return binding.getRoot();
    }

    /*
     * There we set content for included article layouts
     * We do this programmatically because it's impossible to set overrided android:text argument in included xml layout
     */
    private void setTexts() {
        binding.aboutPatron.header.setText(R.string.about_patron_header);
        binding.aboutPatron.content.setText(R.string.about_patron_content);
    }
}
