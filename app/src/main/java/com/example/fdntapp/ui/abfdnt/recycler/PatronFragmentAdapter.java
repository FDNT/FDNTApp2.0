package com.example.fdntapp.ui.abfdnt.recycler;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fdntapp.R;

public class PatronFragmentAdapter extends RecyclerView.Adapter<PatronFragmentAdapter.ViewHolder> {

    private final String[] dataSet;

    public PatronFragmentAdapter(String[] dataSet) {
        this.dataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final int COLLAPSED_MAX_LINES = 4;
        private TextView textView;
        private ImageView expandCollapseIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            expandCollapseIcon = (ImageView) itemView.findViewById(R.id.expand_collapse_icon);
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
                .inflate(R.layout.expandable_text_view, parent, false);
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
