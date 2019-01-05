package com.backendme.sharebtnanimation

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private var isvisible = 0
    var constraint: ConstraintLayout? = null
    private lateinit var btnup: Button
    private lateinit var btndown: Button
    private lateinit var btncenter: Button
    private lateinit var btntight: Button
    private lateinit var btnleft: Button
    private lateinit var constraintSet2: ConstraintSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(1024, 1024)
        setContentView(R.layout.activity_main)
        constraint = findViewById(R.id.con1)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraint)
        constraintSet2 = ConstraintSet()
        constraintSet2.clone(constraint)
        btnup = findViewById(R.id.upbtn)
        btndown = findViewById(R.id.downbtn)
        btncenter = findViewById(R.id.centerbtn)
        btnleft = findViewById(R.id.leftbtn)
        btntight = findViewById(R.id.rightbtn)





        btncenter.setOnClickListener {

            if (isvisible == 0) {
                btnup()
                btndown()
                btnleft()
                btnright()

                isvisible = 1

            } else {
                val transition = ChangeBounds()
                transition.interpolator = AnticipateOvershootInterpolator()
                transition.duration = 1000
                TransitionManager.beginDelayedTransition(constraint, transition)
                constraintSet.applyTo(constraint)
                isvisible = 0

            }


        }
    }

    private fun btnup() {

        constraintSet2.connect(btnup.id, ConstraintSet.END, btncenter.id, ConstraintSet.END)
        constraintSet2.connect(btnup.id, ConstraintSet.START, btncenter.id, ConstraintSet.START)
        constraintSet2.connect(btnup.id, ConstraintSet.BOTTOM, btncenter.id, ConstraintSet.TOP)
        constraintSet2.connect(btnup.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet2.setVerticalBias(btnup.id, 0.8f)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator()
        transition.duration = 1000
        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet2.applyTo(constraint)

    }


    private fun btndown() {
        constraintSet2.connect(btndown.id, ConstraintSet.END, btncenter.id, ConstraintSet.END)
        constraintSet2.connect(btndown.id, ConstraintSet.START, btncenter.id, ConstraintSet.START)
        constraintSet2.connect(btndown.id, ConstraintSet.TOP, btncenter.id, ConstraintSet.BOTTOM)
        constraintSet2.connect(btndown.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet2.setVerticalBias(btndown.id, 0.2f)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator()
        transition.duration = 1000
        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet2.applyTo(constraint)

    }

    private fun btnright() {
        constraintSet2.connect(btntight.id, ConstraintSet.BOTTOM, btncenter.id, ConstraintSet.BOTTOM)
        constraintSet2.connect(btntight.id, ConstraintSet.START, btncenter.id, ConstraintSet.END)
        constraintSet2.connect(btntight.id, ConstraintSet.TOP, btncenter.id, ConstraintSet.TOP)
        constraintSet2.connect(btntight.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator()
        transition.duration = 1000
        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet2.applyTo(constraint)

    }

    private fun btnleft() {

        constraintSet2.connect(btnleft.id, ConstraintSet.END, btncenter.id, ConstraintSet.START)
        constraintSet2.connect(btnleft.id, ConstraintSet.BOTTOM, btncenter.id, ConstraintSet.BOTTOM)
        constraintSet2.connect(btnleft.id, ConstraintSet.TOP, btncenter.id, ConstraintSet.TOP)
        constraintSet2.connect(btnleft.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator()
        transition.duration = 1000
        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet2.applyTo(constraint)
    }


}






