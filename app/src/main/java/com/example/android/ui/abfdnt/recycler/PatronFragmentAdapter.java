package com.example.android.ui.abfdnt.recycler;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

public class PatronFragmentAdapter extends RecyclerView.Adapter<PatronFragmentAdapter.ViewHolder> {

    private final String[] dataSet;

    public PatronFragmentAdapter(String[] dataSet) {
        this.dataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final int COLLAPSED_MAX_LINES = 4;
        private final TextView textView;
        private final ImageView expandCollapseIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            expandCollapseIcon = itemView.findViewById(R.id.expandable_text); //TODO: expand_collpse_cośtam
            textView.setOnClickListener(this);
            expandCollapseIcon.setOnClickListener(this);
        }

        public TextView getText() {
            return textView;
        }

        @Override
        public void onClick(View v) {
            TextViewTransformation(textView);
        }

        private void TextViewTransformation(TextView textView) {
            int duration = (textView.getLineCount() - COLLAPSED_MAX_LINES) * 10;
            if (isCollapsed(textView)) {
                ObjectAnimator animator = ObjectAnimator.ofInt(textView, "maxLines",
                        textView.getLineCount());
                animator.setDuration(duration).start();
                expandCollapseIcon.setImageResource(R.drawable.ic_baseline_expand_less_24);
            }
            else {
                ObjectAnimator animator = ObjectAnimator.ofInt(textView, "maxLines",
                        COLLAPSED_MAX_LINES);
                animator.setDuration(duration).start();
                expandCollapseIcon.setImageResource(R.drawable.ic_baseline_expand_more_24);
            }
        }
        private boolean isCollapsed(TextView textView) {
            return  textView.getMaxLines() == COLLAPSED_MAX_LINES;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_patron, parent, false); //TODO: expandable_text_view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getText().setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
