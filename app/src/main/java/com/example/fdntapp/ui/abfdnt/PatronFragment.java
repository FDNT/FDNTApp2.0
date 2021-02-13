package com.example.fdntapp.ui.abfdnt;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.FragmentPatronBinding;
import com.example.fdntapp.ui.abfdnt.recycler.PatronFragmentAdapter;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class PatronFragment extends Fragment {
    private final int COLLAPSED_MAX_LINES = 4;
    FragmentPatronBinding binding;
    //
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPatronBinding.inflate(inflater, container, false);
        String[] dataSet = {
                "Lorem ipsum dolor sit amet, " +
                        "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Eget aliquet nibh praesent tristique magna. Sed egestas egestas fringilla phasellus faucibus scelerisque " +
                        "eleifend donec. Velit aliquet sagittis id consectetur purus ut faucibus pulvinar elementum. Purus faucibus " +
                        "ornare suspendisse sed nisi lacus. Egestas fringilla phasellus faucibus scelerisque eleifend. Ullamcorper " +
                        "eget nulla facilisi etiam dignissim. Molestie at elementum eu facilisis sed odio morbi quis. Ut etiam sit " +
                        "amet nisl purus in mollis nunc sed. Sem nulla pharetra diam sit amet nisl suscipit adipiscing. Mollis nunc " +
                        "sed id semper",};
        PatronFragmentAdapter patronFragmentAdapter = new PatronFragmentAdapter(dataSet);
        binding.recyclerView.setAdapter(patronFragmentAdapter);
        return binding.getRoot();

    }
}
