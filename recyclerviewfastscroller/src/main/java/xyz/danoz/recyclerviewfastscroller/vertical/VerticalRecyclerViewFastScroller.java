package xyz.danoz.recyclerviewfastscroller.vertical;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import xyz.danoz.recyclerviewfastscroller.R;
import xyz.danoz.recyclerviewfastscroller.AbsRecyclerViewFastScroller;
import xyz.danoz.recyclerviewfastscroller.RecyclerViewScroller;
import xyz.danoz.recyclerviewfastscroller.calculation.VerticalScrollBoundsProvider;
import xyz.danoz.recyclerviewfastscroller.calculation.count.NumberItemsPerPageCalculator;
import xyz.danoz.recyclerviewfastscroller.calculation.count.VerticalLinearLayoutManagerNumberItemsPerPageCalculator;
import xyz.danoz.recyclerviewfastscroller.calculation.position.VerticalScreenPositionCalculator;
import xyz.danoz.recyclerviewfastscroller.calculation.progress.TouchableScrollProgressCalculator;
import xyz.danoz.recyclerviewfastscroller.calculation.progress.VerticalLinearLayoutManagerScrollProgressCalculator;
import xyz.danoz.recyclerviewfastscroller.calculation.progress.VerticalScrollProgressCalculator;
import xyz.danoz.recyclerviewfastscroller.utils.ViewUtils;

/**
 * Widget used to fast-scroll a vertical {@link RecyclerView}.
 * Currently assumes the use of a {@link LinearLayoutManager}
 */
public class VerticalRecyclerViewFastScroller extends AbsRecyclerViewFastScroller implements RecyclerViewScroller {

    private VerticalScrollProgressCalculator mScrollProgressCalculator;
    private VerticalScreenPositionCalculator mScreenPositionCalculator;
    private NumberItemsPerPageCalculator mNumberItemsPerPageCalculator;

    public VerticalRecyclerViewFastScroller(Context context) {
        this(context, null);
    }

    public VerticalRecyclerViewFastScroller(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalRecyclerViewFastScroller(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.vertical_recycler_fast_scroller_layout;
    }

    @Override
    protected TouchableScrollProgressCalculator getScrollProgressCalculator() {
        return mScrollProgressCalculator;
    }

    @Override
    public void moveHandleToPosition(float scrollProgress) {
        final float yPos = mScreenPositionCalculator.getYPositionFromScrollProgress(scrollProgress);
        ViewUtils.setY(mHandle, yPos);
    }

    @Override
    public int getNumItemsPerPage(RecyclerView recyclerView) {
        return mNumberItemsPerPageCalculator.calculateNumItemsPerPage(recyclerView);
    }

    @Override
    protected void setStandardScrollerEnabled(RecyclerView recyclerView, boolean enabled) {
        recyclerView.setVerticalScrollBarEnabled(enabled);
    }

    @Override
    protected Animation loadShowAnimation() {
        return AnimationUtils.loadAnimation(getContext(), R.anim.fast_scroller_slide_in_right);
    }

    @Override
    protected Animation loadHideAnimation() {
        return AnimationUtils.loadAnimation(getContext(), R.anim.fast_scroller_slide_out_right);
    }

    @Override
    protected void onCreateScrollProgressCalculator() {
        final float barY = ViewUtils.getY(mBar);
        VerticalScrollBoundsProvider boundsProvider =
                new VerticalScrollBoundsProvider(barY, barY + mBar.getHeight() - mHandle.getHeight());
        mScrollProgressCalculator = new VerticalLinearLayoutManagerScrollProgressCalculator(boundsProvider);
        mScreenPositionCalculator = new VerticalScreenPositionCalculator(boundsProvider);
        mNumberItemsPerPageCalculator = new VerticalLinearLayoutManagerNumberItemsPerPageCalculator();
    }
}
