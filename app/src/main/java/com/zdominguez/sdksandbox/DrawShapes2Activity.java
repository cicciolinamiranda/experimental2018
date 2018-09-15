package com.zdominguez.sdksandbox;

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

        List<RectanglePoints> rectanglePointsList = new ArrayList<RectanglePoints>() {{
            add(new RectanglePoints(new Rect(130, 130, 180, 180), ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_red_dark), "Red"));
            add(new RectanglePoints(new Rect(133, 160, 177, 177), ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_blue_dark), "Blue"));
            add(new RectanglePoints(new Rect(133, 133, 177, 160), ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_orange_dark), "Orange"));
            add(new RectanglePoints(new Rect(200, 200, 300, 300), ContextCompat.getColor(DrawShapes2Activity.this, android.R.color.holo_green_dark), "Green"));

        }};

        drawingView = new DrawingView(this, rectanglePointsList, this);
        relativeLayout.addView(drawingView);


    }

    @Override
    public void onClickListener(RectanglePoints rectanglePoints) {
        Toast.makeText(DrawShapes2Activity.this, rectanglePoints.getLabel(), Toast.LENGTH_LONG).show();
    }
}
