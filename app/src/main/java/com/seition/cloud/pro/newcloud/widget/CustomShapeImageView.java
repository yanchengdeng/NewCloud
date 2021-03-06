package com.seition.cloud.pro.newcloud.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import com.seition.cloud.pro.newcloud.R;


/**
 * Created by Mostafa Gazar on 11/2/13.
 */
public class CustomShapeImageView extends CustomShapeImageBase {

    public static class Shape {
        public static final int CIRCLE = 1;
        public static final int RECTANGLE = 2;
        public static final int SVG    = 3;
    }

    private int mShape = Shape.CIRCLE;

    public CustomShapeImageView(Context context) {
        super(context);
    }

    public CustomShapeImageView(Context context, int resourceId, int shape) {
        this(context);
        setImageResource(resourceId);
        mShape = shape;
    }

    public CustomShapeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        sharedConstructor(context, attrs);
    }

    public CustomShapeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        sharedConstructor(context, attrs);
    }

    private void sharedConstructor(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomShapeImageView);
        mShape = a.getInt(R.styleable.CustomShapeImageView_shape, Shape.CIRCLE);
        a.recycle();
    }

    @Override
    public Bitmap getBitmap() {
        switch (mShape) {
            case Shape.CIRCLE:
                return CustomShapeCircleImage.getBitmap(getWidth(), getHeight());
            case Shape.RECTANGLE:
                return CustomShapeRectangleImage.getBitmap(getWidth(), getHeight());
        }
        return null;
    }

}
