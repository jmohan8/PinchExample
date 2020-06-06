package com.example.pinchexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import kotlinx.android.synthetic.main.activity_pinch_example.*

class PinchExampleActivity : AppCompatActivity() {

    var scaleGestureDetector: ScaleGestureDetector? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinch_example)
        scaleGestureDetector = ScaleGestureDetector(this, MyOnScaleGestuteListner())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector?.onTouchEvent(event)
        return true
    }

    inner class MyOnScaleGestuteListner : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            val scaleFactor = detector?.scaleFactor

            if (scaleFactor != null) {
                if (scaleFactor > 1)
                    myTextView.text = "Zooming out"
                else
                    myTextView.text = "Zoomin in"
            }
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return super.onScaleBegin(detector)
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
            super.onScaleEnd(detector)
        }
    }
}