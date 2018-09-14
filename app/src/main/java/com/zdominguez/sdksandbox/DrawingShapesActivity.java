package com.zdominguez.sdksandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zdominguez.sdksandbox.custom.MyView;

public class DrawingShapesActivity extends AppCompatActivity {

    SeekBar radiusBar;
    MyView myView;

    SeekBar ptBar;
    TextView textPt;
    final static int MIN_PT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_shapes);
        radiusBar = (SeekBar) findViewById(R.id.radiusbar);
        myView = (MyView) findViewById(R.id.myview);
        float defaultRatio = (float) (radiusBar.getProgress())
                / (float) (radiusBar.getMax());
        myView.setShapeRadiusRatio(defaultRatio);

        radiusBar.setOnSeekBarChangeListener(radiusBarOnSeekBarChangeListener);

        textPt = (TextView)findViewById(R.id.pttext);
        ptBar = (SeekBar)findViewById(R.id.ptbar);
        ptBar.setOnSeekBarChangeListener(ptBarOnSeekBarChangeListener);



    }

    SeekBar.OnSeekBarChangeListener radiusBarOnSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    float ratio = (float) (radiusBar.getProgress())
                            / (float) (radiusBar.getMax());
                    myView.setShapeRadiusRatio(ratio);
                    myView.invalidate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}

            };

    SeekBar.OnSeekBarChangeListener ptBarOnSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    int pt = progress + MIN_PT;
                    textPt.setText("number of point in polygon: " + String.valueOf(pt));
                    myView.setNumberOfPoint(pt);
                    myView.invalidate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}

            };


}
