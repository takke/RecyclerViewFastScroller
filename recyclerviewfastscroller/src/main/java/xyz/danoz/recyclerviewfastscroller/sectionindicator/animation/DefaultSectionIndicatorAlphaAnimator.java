package xyz.danoz.recyclerviewfastscroller.sectionindicator.animation;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

/**
 * Default implementation of the {@link SectionIndicatorAlphaAnimator}
 */
public class DefaultSectionIndicatorAlphaAnimator implements SectionIndicatorAlphaAnimator {

    private static final int ANIMATION_DURATION = 500;

    private final View mSectionIndicatorView;
    private float mTargetAlpha = 0;

    public DefaultSectionIndicatorAlphaAnimator(View sectionIndicatorView) {
        mSectionIndicatorView = sectionIndicatorView;
        ViewCompat.setAlpha(mSectionIndicatorView, 0);
    }

    @Override
    public void animateTo(float target) {
        if (target == mTargetAlpha) {
            return;
        }

        mTargetAlpha = target;

        ViewPropertyAnimatorCompat animator = ViewCompat.animate(mSectionIndicatorView);

        animator.cancel();
        animator.alpha(mTargetAlpha);
        animator.setDuration(ANIMATION_DURATION);
        animator.start();
    }
}
