package xyz.danoz.recyclerviewfastscroller;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

import xyz.danoz.recyclerviewfastscroller.sectionindicator.SectionIndicator;

/**
 * Touch listener that will move a {@link AbsRecyclerViewFastScroller}'s handle to a specified offset along the scroll bar
 */
class FastScrollerTouchListener implements OnTouchListener {

    private final AbsRecyclerViewFastScroller mFastScroller;

    /**
     * @param fastScroller {@link xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller} for this listener to scroll
     */
    public FastScrollerTouchListener(AbsRecyclerViewFastScroller fastScroller) {
        mFastScroller = fastScroller;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mFastScroller.setIsGrabbingHandle(true);
                break;
            case MotionEvent.ACTION_UP:
                mFastScroller.setIsGrabbingHandle(false);
                break;
        }

        SectionIndicator sectionIndicator = mFastScroller.getSectionIndicator();
        showOrHideIndicator(sectionIndicator, event);

        float scrollProgress = mFastScroller.getScrollProgress(event);
        mFastScroller.scrollTo(scrollProgress, true);
        mFastScroller.moveHandleToPosition(scrollProgress);
        return true;
    }

    private void showOrHideIndicator(@Nullable SectionIndicator sectionIndicator, MotionEvent event) {
        if (sectionIndicator == null) {
            return;
        }

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                sectionIndicator.showWithAnimation();
                return;
            case MotionEvent.ACTION_UP:
                sectionIndicator.hideWithAnimation();
                break;
        }
    }

}
