package xyz.danoz.recyclerviewfastscroller.utils;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtils {
    private ViewUtils() {
    }

    /**
     * Compatibility version of the View.setX() method.
     * @param view target view
     * @param position x position
     */
    public static void setX(View view, float position) {
        if (supportsViewTranslation()) {
            ViewCompat.setX(view, position);
        } else {
            final ViewGroup.MarginLayoutParams lp = getMarginLayoutParams(view);
            lp.leftMargin = (int) (position + 0.5f);
            view.setLayoutParams(lp);
        }
    }

    /**
     * Compatibility version of the View.getX() method.
     * @param view target view
     * @return x position
     */
    public static float getX(View view) {
        if (supportsViewTranslation()) {
            return ViewCompat.getX(view);
        } else {
            final ViewGroup.MarginLayoutParams lp = getMarginLayoutParams(view);
            return lp.leftMargin;
        }
    }

    /**
     * Compatibility version of the View.setY() method.
     * @param view target view
     * @param position y position
     */
    public static void setY(View view, float position) {
        if (supportsViewTranslation()) {
            ViewCompat.setY(view, position);
        } else {
            final ViewGroup.MarginLayoutParams lp = getMarginLayoutParams(view);
            lp.topMargin = (int) (position + 0.5f);
            view.setLayoutParams(lp);
        }
    }

    /**
     * Compatibility version of the View.getY() method.
     * @param view target view
     * @return y position
     */
    public static float getY(View view) {
        if (supportsViewTranslation()) {
            return ViewCompat.getY(view);
        } else {
            final ViewGroup.MarginLayoutParams lp = getMarginLayoutParams(view);
            return lp.topMargin;
        }
    }

    private static ViewGroup.MarginLayoutParams getMarginLayoutParams(View view) {
        final ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return (ViewGroup.MarginLayoutParams) lp;
        } else {
            throw new IllegalStateException("Parent does not support MarginLayoutParams");
        }
    }

    private static boolean supportsViewTranslation() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB);
    }
}
