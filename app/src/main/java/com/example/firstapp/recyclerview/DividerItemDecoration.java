package com.example.firstapp.recyclerview;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private final int verticalSpaceHeight;
    private final int verticalSpaceWidth;


    public DividerItemDecoration(int verticalSpaceHeight, int verticalSpaceWidth) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        this.verticalSpaceWidth = verticalSpaceWidth;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom=verticalSpaceHeight;
        outRect.right = verticalSpaceWidth;
    }
}
