package com.example.android.ui.abfdnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.R;
import com.example.android.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {
    FragmentAboutBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        setTexts();
        return binding.getRoot();
    }

    /*
    * There we set content for included article layouts
    * We do this programmatically because it's impossible to set overrided android:text argument in included xml layout
     */
    private void setTexts() {
        binding.whoAreWe.header.setText(R.string.who_are_we);
        binding.whoAreWe.content.setText(R.string.who_are_we_content);
        binding.whatWeDoing.header.setText(R.string.what_we_doing);
        binding.whatWeDoing.content.setText(R.string.what_we_doing_content);
        binding.aboutPatron.header.setText(R.string.about_patron_header);
        binding.aboutPatron.content.setText(R.string.about_patron_content);
    }
}