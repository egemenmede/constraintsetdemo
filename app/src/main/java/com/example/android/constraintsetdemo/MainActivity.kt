package com.example.android.constraintsetdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var textView2: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView2 = findViewById(R.id.textView2)

        var set = false
        val startCs = ConstraintSet()
        startCs.clone(container)
        val finishCs = ConstraintSet()
        finishCs.clone(this, R.layout.animation_end)

        imageView.setOnClickListener {
            TransitionManager.beginDelayedTransition(container)
            val constraint = if (set) startCs else finishCs
            if (set) {
                finishCs.setVisibility(textView2.id, ConstraintSet.GONE)
            } else {
                finishCs.setVisibility(textView2.id, ConstraintSet.VISIBLE)
            }
            constraint.applyTo(container)
            set = !set
        }
    }
}
