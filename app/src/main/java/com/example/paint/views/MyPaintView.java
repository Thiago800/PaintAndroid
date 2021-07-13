package com.example.paint.views;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;

public class MyPaintView extends View {

        private static Paint paint;
        private List<Point> pointList;
        private Path drawPath;
        private static Color color;

    public static void setColor(Color chooseColor) {
        color = chooseColor;
        setColor();
    }

    public MyPaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        drawPath = new Path();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color == null ? Color.BLUE : color.toArgb());
        paint.setTextSize(50);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPosition = event.getX();
        float yPosition = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(xPosition, yPosition);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(xPosition, yPosition);
                break;
            default:
                return false;

        }

        postInvalidate();
        return true;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(drawPath, paint);
    }

    private static void setColor() {
        paint.setColor(color == null ? Color.BLUE : color.toArgb());
    }
}
