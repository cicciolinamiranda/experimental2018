package com.zdominguez.sdksandbox.custom;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

public class RectanglePoints {


    private Rect rect;
    private int colorIntValue;
    private String label;

    public RectanglePoints(Rect rect, int colorIntValue, String label) {
        this.rect = rect;
        this.colorIntValue = colorIntValue;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int getColorIntValue() {
        return colorIntValue;
    }

    public void setColorIntValue(int colorIntValue) {
        this.colorIntValue = colorIntValue;
    }
}
