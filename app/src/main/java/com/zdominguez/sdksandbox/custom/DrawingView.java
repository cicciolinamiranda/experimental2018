package com.zdominguez.sdksandbox.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private List<DrawingPoints> drawingPoints;
    private DrawingViewInterface drawingViewInterface;
    private Canvas canvas;

    public DrawingView(Context context, List<DrawingPoints> drawingPoints, DrawingViewInterface drawingViewInterface) {
        super(context);
        this.paint = new Paint();
        this.drawingPoints = drawingPoints;
        this.drawingViewInterface = drawingViewInterface;
    }


    @Override
    public void onDraw(Canvas canvas) {
        this.canvas = canvas;
        for(DrawingPoints drawingPoints : this.drawingPoints) {
            paint.setColor(drawingPoints.getColorIntValue());

            if(drawingPoints.isSelected()) {
                paint.setAlpha(5);
            }

            canvas.drawPath(drawingPoints.getPath(), paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && drawingPoints != null) {

            for(DrawingPoints rectanglePoint: drawingPoints) {

                if(rectanglePoint.getPath() != null) {

                    RectF rectF = new RectF();
                    rectanglePoint.getPath().computeBounds(rectF, true);

                    Region r = new Region();
                    r.setPath(rectanglePoint.getPath(), new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));

                    if(r.contains((int) event.getX(), (int) event.getY())) {

                        rectanglePoint.setSelected(!rectanglePoint.isSelected());
                        drawingViewInterface.onClickListener(rectanglePoint);
                        invalidate();
                        break;
                    }
                }

            }
        }
        return false;
    }

    public interface DrawingViewInterface {
        void onClickListener(DrawingPoints drawingPoints);
    }

}

