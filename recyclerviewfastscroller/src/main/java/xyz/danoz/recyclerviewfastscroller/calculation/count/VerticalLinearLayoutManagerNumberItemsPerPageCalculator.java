package xyz.danoz.recyclerviewfastscroller.calculation.count;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VerticalLinearLayoutManagerNumberItemsPerPageCalculator implements NumberItemsPerPageCalculator {
    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNumItemsPerPage(RecyclerView recyclerView) {
        // NOTE: This process expects LinearLayoutManager and hasFixedSize() == true
        View visibleChild = recyclerView.getChildAt(0);
        RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(visibleChild);
        int itemHeight = holder.itemView.getHeight();
        int recyclerHeight = recyclerView.getHeight();
        int itemsInWindow = recyclerHeight / itemHeight;

        return itemsInWindow;
    }
}
