package com.github.jinatonic.confetti.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Px;

public class EmojiBitmapFactory {

    public static Bitmap create(Context context, String emoji, @Px int size) {
        CaptureTextView captureView = new CaptureTextView(context, size);
        return captureView.capture(emoji);
    }

    @SuppressLint("AppCompatCustomView")
    private static class CaptureTextView extends TextView {

        @Px
        int size;

        CaptureTextView(Context context, @Px int size) {
            super(context);
            this.size = size;
        }

        Bitmap capture(String emoji) {
            setText(emoji);
            invalidate();
            setDrawingCacheEnabled(true);
            measure(View.MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY));
            layout(0, 0, size, size);
            Bitmap bitmap = Bitmap.createBitmap(getDrawingCache());
            setDrawingCacheEnabled(false);
            return bitmap;
        }
    }
}
