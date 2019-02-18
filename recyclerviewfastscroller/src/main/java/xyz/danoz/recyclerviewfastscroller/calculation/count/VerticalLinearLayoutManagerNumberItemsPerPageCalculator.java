package xyz.danoz.recyclerviewfastscroller.calculation.count;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalLinearLayoutManagerNumberItemsPerPageCalculator implements NumberItemsPerPageCalculator {
    /**
     * {@inheritDoc}
     */
    @Override
    public float calculateNumItemsPerPage(RecyclerView recyclerView) {
        // NOTE: This process expects LinearLayoutManager and hasFixedSize() == true
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        int visibleItemPos = layoutManager.findFirstVisibleItemPosition();

        if (visibleItemPos == RecyclerView.NO_POSITION) {
            return 1;
        }

        RecyclerView.ViewHolder vh = recyclerView.findViewHolderForPosition(visibleItemPos);
        int itemHeight = vh.itemView.getHeight();

        if (itemHeight == 0) {
            return 1;
        }

        int recyclerHeight = layoutManager.getHeight();
        float itemsPerPage = (float) recyclerHeight / itemHeight;

        return itemsPerPage;
    }
}
