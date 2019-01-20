package com.zdominguez.sdksandbox.custom;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

public class DrawingPoints {


    private Path path;
    private int colorIntValue;
    private String label;
    private boolean isSelected;

    public DrawingPoints(Path path, int colorIntValue, String label) {
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
