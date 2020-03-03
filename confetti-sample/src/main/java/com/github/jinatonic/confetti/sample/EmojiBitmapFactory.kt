package com.github.jinatonic.confetti.sample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.TextView
import androidx.annotation.Px

object EmojiBitmapFactory {

    private val debug = true

    @JvmStatic
    fun create(context: Context, emoji: String, @Px size: Float): Bitmap {
        val captureView = CaptureTextView(context, size)
        return captureView.capture(emoji)
    }

    @SuppressLint("AppCompatCustomView")
    private class CaptureTextView internal constructor(context: Context, var size: Float) : TextView(context) {

        fun capture(emoji: String?): Bitmap {
            //textSize = size
            text = emoji
            measure(
                MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            layout(0, 0, measuredWidth, measuredHeight)
            val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val c = Canvas(b)
            if (debug) {
                c.drawColor(Color.RED)
            }
            draw(c)
            return b

        }

    }
}
