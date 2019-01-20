package com.zdominguez.sdksandbox;

import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zdominguez.sdksandbox.custom.DrawingView;
import com.zdominguez.sdksandbox.custom.DrawingPoints;
import com.zdominguez.sdksandbox.custom.OnPinchListener;
import com.zdominguez.sdksandbox.custom.ZoomableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class DrawShapes2Activity extends AppCompatActivity implements DrawingView.DrawingViewInterface {

    private DrawingView drawingView;
    private ZoomableRelativeLayout relativeLayout;
    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_shapes2);

        relativeLayout = (ZoomableRelativeLayout) findViewById(R.id.container);

        scaleGestureDetector = new ScaleGestureDetector(this, new OnPinchListener(relativeLayout));

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
        final Path path1 = new Path();

        path1.moveTo(0,0);
        path1.lineTo(50, 0);
        path1.lineTo(50 + 120, 50);
        path1.lineTo(120, 50);
        path1.lineTo(0, 0);
        path1.close();
        final Path path2 = new Path();
        path2.moveTo(10,10);
        path2.lineTo(50, 0);
        path2.lineTo(50 + 120, 50);
        path2.lineTo(120, 50);
        path2.lineTo(10, 10);
        path2.close();
        final Path path3 = new Path();
        path3.moveTo(50,160);
        path3.lineTo(50, 0);
        path3.lineTo(50 + 120, 50);
        path3.lineTo(120, 50);
        path3.lineTo(50, 160);
        path3.close();
        final Path path4 = new Path();
        path4.moveTo(200,200);
        path4.lineTo(50, 0);
        path4.lineTo(50 + 120, 50);
        path4.lineTo(120, 50);
        path4.lineTo(200, 200);
        path4.close();

        List<DrawingPoints> drawingPointsList = new ArrayList<DrawingPoints>() {{
            add(new DrawingPoints(path1, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_red_dark), "Red"));
            add(new DrawingPoints(path2, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_blue_dark), "Blue"));
            add(new DrawingPoints(path3, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_orange_dark), "Orange"));
            add(new DrawingPoints(path4, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_green_dark), "Green"));

        }};

        drawingView = new DrawingView(this, drawingPointsList, this);
        relativeLayout.addView(drawingView);


    }

    @Override
    public void onClickListener(DrawingPoints drawingPoints) {
        Toast.makeText(DrawShapes2Activity.this, drawingPoints.getLabel(), Toast.LENGTH_LONG).show();
    }
}
