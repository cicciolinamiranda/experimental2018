package com.zdominguez.sdksandbox.custom;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

public class RectanglePoints {


    private Path path;
    private int colorIntValue;
    private String label;

    public RectanglePoints(Path path, int colorIntValue, String label) {
        this.path = path;
        this.colorIntValue = colorIntValue;
        this.label = label;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getColorIntValue() {
        return colorIntValue;
    }

    public void setColorIntValue(int colorIntValue) {
        this.colorIntValue = colorIntValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
