package com.example.autismcompany;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class OutlinedTextView extends AppCompatTextView {

    // Цвет обводки и её ширина (настраивайте по необходимости)
    private int strokeColor = Color.BLACK;
    private float strokeWidth = 4.0f;

    public OutlinedTextView(Context context) {
        super(context);
    }

    public OutlinedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OutlinedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint textPaint = getPaint();
        // Сохраняем текущий цвет текста
        int currentTextColor = getCurrentTextColor();

        // Рисуем обводку (stroke)
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(strokeWidth);
        setTextColor(strokeColor);
        super.onDraw(canvas);

        // Рисуем заливку (обычный текст)
        textPaint.setStyle(Paint.Style.FILL);
        setTextColor(currentTextColor);
        super.onDraw(canvas);
    }
}