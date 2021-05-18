package com.dawn.kotlinbasedemo.demo.circularreveal

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.dawn.kotlinbasedemo.R


class CircularRevealActivity : AppCompatActivity() {
    var root:View?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_reveal)
        root=findViewById(R.id.parent);
        root?.post {
            onClick(null)
        }
        root?.setOnClickListener{
            val measuredWidth = root?.width!!;
            val measuredHeight =root?.height!!;
            val maxRadius = kotlin.math.hypot(
                measuredWidth!!.toDouble(),
                measuredHeight!!.toDouble()
            );
//        val maxRadius = measuredWidth
            root?.visibility=View.VISIBLE



            ViewAnimationUtils.createCircularReveal(
                root,
                measuredWidth,
                measuredHeight,
                maxRadius.toFloat(),
                0f
            ).apply {
                duration = 500;
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        root?.visibility = View.GONE
                        finish()
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                })

            }.start()
        }
    }

    fun onClick(view: View?) {

        val measuredWidth = root?.width!!;
        val measuredHeight =root?.height!!;
        val maxRadius = kotlin.math.hypot(measuredWidth!!.toDouble(), measuredHeight!!.toDouble());
//        val maxRadius = measuredWidth
        root?.visibility=View.VISIBLE



        ViewAnimationUtils.createCircularReveal(
            root,
            measuredWidth,
            measuredHeight,
            0f,
            maxRadius.toFloat()
        ).apply {
            duration = 500;
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
//                    root?.visibility=View.GONE
//                    finish()
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationRepeat(animation: Animator?) {

                }

            })

        }.start()
    }
}