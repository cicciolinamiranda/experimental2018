package com.zdominguez.sdksandbox;

import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zdominguez.sdksandbox.custom.DrawingView;
import com.zdominguez.sdksandbox.custom.RectanglePoints;

import java.util.ArrayList;
import java.util.List;

public class DrawShapes2Activity extends AppCompatActivity implements DrawingView.DrawingViewInterface {

    private DrawingView drawingView;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_shapes2);

        relativeLayout = (RelativeLayout) findViewById(R.id.container);

        final Path path1 = new Path();

        path1.moveTo(0,0);
        path1.lineTo(50, 0);
        path1.lineTo(50 + 120, 50);
        path1.lineTo(120, 50);
        path1.lineTo(0, 0);
        final Path path2 = new Path();
        path2.moveTo(10,10);
        path2.lineTo(50, 0);
        path2.lineTo(50 + 120, 50);
        path2.lineTo(120, 50);
        path2.lineTo(10, 10);
        final Path path3 = new Path();
        path3.moveTo(50,50);
        path3.lineTo(50, 0);
        path3.lineTo(50 + 120, 50);
        path3.lineTo(120, 50);
        path3.lineTo(50, 50);
        final Path path4 = new Path();
        path4.moveTo(60,60);
        path4.lineTo(50, 0);
        path4.lineTo(50 + 120, 50);
        path4.lineTo(120, 50);
        path4.lineTo(60, 60);

        List<RectanglePoints> rectanglePointsList = new ArrayList<RectanglePoints>() {{
            add(new RectanglePoints(path1, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_red_dark), "Red"));
            add(new RectanglePoints(path2, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_blue_dark), "Blue"));
            add(new RectanglePoints(path3, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_orange_dark), "Orange"));
            add(new RectanglePoints(path4, ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_green_dark), "Green"));

        }};

        drawingView = new DrawingView(this, rectanglePointsList, this);
        relativeLayout.addView(drawingView);


    }

    @Override
    public void onClickListener(RectanglePoints rectanglePoints) {
        Toast.makeText(DrawShapes2Activity.this, rectanglePoints.getLabel(), Toast.LENGTH_LONG).show();
    }
}
