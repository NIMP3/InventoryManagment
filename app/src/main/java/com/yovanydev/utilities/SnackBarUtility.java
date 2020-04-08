package com.yovanydev.utilities;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.yovanydev.R;

public class SnackBarUtility {
    private static int getResourceByType(int resourceType) {
        switch (resourceType) {
            case DialogUtility.ANIMATION_ERROR:
                return R.drawable.ic_error_snb;
            case DialogUtility.ANIMATION_CHECK:
                return R.drawable.ic_error_snb;
            case DialogUtility.ANIMATION_WARNING:
                return R.drawable.ic_warning_snb;
            default:
                return R.drawable.ic_error_snb;
        }
    }

    public static Snackbar createSnackBar(View view, String message, int resourceType) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);

        View snackBarLayout = snackbar.getView();
        TextView textView = snackBarLayout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setCompoundDrawablesWithIntrinsicBounds(getResourceByType(resourceType), 0, 0, 0);
        textView.setCompoundDrawablePadding(view.getResources().getDimensionPixelOffset(R.dimen.drawable_padding));

        return snackbar;
    }
}
