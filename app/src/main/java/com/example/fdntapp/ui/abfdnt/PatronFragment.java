package com.example.fdntapp.ui.abfdnt;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fdntapp.R;
import com.example.fdntapp.databinding.FragmentPatronBinding;

import org.jetbrains.annotations.NotNull;

public class PatronFragment extends Fragment {
    private final int COLLAPSED_MAX_LINES = 4;
    FragmentPatronBinding binding;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPatronBinding.inflate(inflater, container, false);
        binding.textView.setMaxLines(COLLAPSED_MAX_LINES);
        binding.textView.setOnClickListener(v -> TextViewTransformation((TextView) v));
        return binding.getRoot();
    }

    private void TextViewTransformation(TextView textView) {
        int duration = (binding.textView.getLineCount() - COLLAPSED_MAX_LINES) * 10;
        if (isCollapsed(textView)) {

            ObjectAnimator animator = ObjectAnimator.ofInt(binding.textView, "maxLines",
                    binding.textView.getLineCount());
            animator.setDuration(duration).start();
        }
        else {
            ObjectAnimator animator = ObjectAnimator.ofInt(binding.textView, "maxLines",
                    COLLAPSED_MAX_LINES);
            animator.setDuration(duration).start();
        }
    }

    private boolean isCollapsed(TextView textView) {
        return textView.getMaxLines() == COLLAPSED_MAX_LINES;
    }
}
