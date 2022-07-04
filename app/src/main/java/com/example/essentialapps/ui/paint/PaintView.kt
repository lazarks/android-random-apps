package com.example.essentialapps.ui.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class PaintView: View{
    var params: ViewGroup.LayoutParams? = null
    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    constructor(context: Context) : this(context, null) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }


    private fun init() {
        PaintFragment.paintBrush.isAntiAlias = true
        PaintFragment.paintBrush.color = currentBrush
        PaintFragment.paintBrush.style = Paint.Style.STROKE
        PaintFragment.paintBrush.strokeJoin = Paint.Join.ROUND
        PaintFragment.paintBrush.strokeWidth = 8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                PaintFragment.path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                PaintFragment.path.lineTo(x, y)
                pathList.add(PaintFragment.path)
                colorList.add(currentBrush)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas){
        for(i in pathList.indices){
            PaintFragment.paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], PaintFragment.paintBrush)
            invalidate()
        }
    }
}