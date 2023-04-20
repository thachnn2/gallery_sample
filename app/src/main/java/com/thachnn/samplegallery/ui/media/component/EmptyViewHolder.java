package com.thachnn.samplegallery.ui.media.component;

import android.view.View;
import android.widget.TextView;

import com.thachnn.samplegallery.R;

public class EmptyViewHolder {
    View container;
    TextView tvMessage;

    public EmptyViewHolder(View root) {
        this.container = root.findViewById(R.id.llEmptyContainer);
        tvMessage = root.findViewById(R.id.tvMessage);
    }

    public void visible() {
        this.container.setVisibility(View.VISIBLE);
    }

    public void gone() {
        this.container.setVisibility(View.GONE);
    }

    public void setText(String text) {
        this.tvMessage.setText(text);
    }
}
