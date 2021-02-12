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
import org.w3c.dom.Text;

public class PatronFragment extends Fragment {
    private final int COLLAPSED_MAX_LINES = 4;
    FragmentPatronBinding binding;
    //
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPatronBinding.inflate(inflater, container, false);
        setClickListener();
        return binding.getRoot();

    }

    private void setClickListener() {
        binding.expandable.text.setOnClickListener(v -> TextViewTransformation(binding.expandable.text));
        binding.expandable.expandCollapseIcon.setOnClickListener(v -> TextViewTransformation(binding.expandable.text));
    }

    private void TextViewTransformation(TextView textView) {
        int duration = (binding.expandable.text.getLineCount() - COLLAPSED_MAX_LINES) * 10;
        if (isCollapsed(textView)) {
            ObjectAnimator animator = ObjectAnimator.ofInt(binding.expandable.text, "maxLines",
                    binding.expandable.text.getLineCount());
            animator.setDuration(duration).start();
            binding.expandable.expandCollapseIcon.setImageResource(R.drawable.ic_baseline_expand_less_24);
        }
        else {
            ObjectAnimator animator = ObjectAnimator.ofInt(binding.expandable.text, "maxLines",
                    COLLAPSED_MAX_LINES);
            animator.setDuration(duration).start();
            binding.expandable.expandCollapseIcon.setImageResource(R.drawable.ic_baseline_expand_more_24);
        }
    }
    private boolean isCollapsed(TextView textView) {
        return  textView.getMaxLines() == COLLAPSED_MAX_LINES;
    }

}
