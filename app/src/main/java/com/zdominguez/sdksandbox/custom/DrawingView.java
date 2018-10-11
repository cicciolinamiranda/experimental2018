package com.zdominguez.sdksandbox.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

public class DrawingView extends View {

    Paint paint = new Paint();
    private List<RectanglePoints> rectanglePoints;
    private DrawingViewInterface drawingViewInterface;

    public DrawingView(Context context, List<RectanglePoints> rectanglePoints, DrawingViewInterface drawingViewInterface) {
        super(context);
        this.rectanglePoints = rectanglePoints;
        this.drawingViewInterface = drawingViewInterface;
    }


    @Override

    public void onDraw(Canvas canvas) {

        for(RectanglePoints rectanglePoints: rectanglePoints) {
            paint.setColor(rectanglePoints.getColorIntValue());
            canvas.drawPath(rectanglePoints.getPath(), paint);
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && rectanglePoints != null) {

            for(RectanglePoints rectanglePoint: rectanglePoints) {

                if(rectanglePoint.getPath() != null) {

                    RectF rectF = new RectF();
                    rectanglePoint.getPath().computeBounds(rectF, true);

                    if(rectF.contains((int) event.getX(), (int) event.getY())) {
                        drawingViewInterface.onClickListener(rectanglePoint);
                    }
                }

            }
        }
        return false;
    }

    public interface DrawingViewInterface {
        void onClickListener(RectanglePoints rectanglePoints);
    }

}

