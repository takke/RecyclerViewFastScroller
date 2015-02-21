package xyz.danoz.recyclerviewfastscroller.sectionindicator.animation;

import android.view.View;

/**
 * This class is intended to use for API 10 or older devices which do not support *alpha* property of views.
 */
public class LegacyCompatSectionIndicatorAlphaAnimator implements SectionIndicatorAlphaAnimator {

    private final View mSectionIndicatorView;
    private float mTargetAlpha = 0;

    public LegacyCompatSectionIndicatorAlphaAnimator(View sectionIndicatorView) {
        mSectionIndicatorView = sectionIndicatorView;
        mSectionIndicatorView.setVisibility(View.INVISIBLE);
    }

    public void animateTo(float target){
        if (target == mTargetAlpha) {
            return;
        }

        mTargetAlpha = target;

        if (mTargetAlpha >= 0.5f) {
            mSectionIndicatorView.setVisibility(View.VISIBLE);
        } else {
            mSectionIndicatorView.setVisibility(View.INVISIBLE);
        }
    }
}
