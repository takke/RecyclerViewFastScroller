package xyz.danoz.recyclerviewfastscroller.calculation.count;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class VerticalLinearLayoutManagerNumberItemsPerPageCalculator implements NumberItemsPerPageCalculator {
    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNumItemsPerPage(RecyclerView recyclerView) {
        // NOTE: This process expects LinearLayoutManager and hasFixedSize() == true
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        int visibleItemPos = layoutManager.findFirstVisibleItemPosition();

        if (visibleItemPos == RecyclerView.NO_POSITION) {
            return 1;
        }

        RecyclerView.ViewHolder vh = recyclerView.findViewHolderForPosition(visibleItemPos);
        int recyclerHeight = layoutManager.getHeight();
        int itemsPerPage = recyclerHeight / vh.itemView.getHeight();

        return itemsPerPage;
    }
}
