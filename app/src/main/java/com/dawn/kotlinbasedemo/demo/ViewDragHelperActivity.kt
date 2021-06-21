package com.dawn.kotlinbasedemo.demo

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.graphics.Path
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.dawn.kotlinbasedemo.R
import com.dawn.lib_common.util.log


class ViewDragHelperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_drag_helper)
        findViewById<View>(R.id.gone_view).setOnClickListener {
            it.visibility=View.GONE
        }
        findViewById<View>(R.id.v_view).setOnClickListener {
            findViewById<View>(R.id.gone_view).visibility=View.VISIBLE
        }

        findViewById<ViewGroup>(R.id.show_Ll).layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        findViewById<TextView>(R.id.show_text).setOnClickListener {
            (it as TextView).text="222222222220000000"
            it.visibility=View.GONE
        }

        findViewById<View>(R.id.gone_view1).setOnClickListener {
            log("===onLocation=0=${it.x}==${it.y}=")
            log("===onLocation=1=${it.left}==${it.y}=")
            val path = Path().apply {

//                quadTo(50f, 300f, 500f,0f);
                moveTo(it.x,it.y)
                lineTo(it.x+it.width,0f)
            }

            ObjectAnimator.ofFloat(it, "translationX", 60f).apply {
                duration = 1000
                start()
            }













//












//            val animator = ObjectAnimator.ofFloat(it, View.X, View.Y, path).apply {
//                duration = 2000
//                interpolator=AccelerateInterpolator()
//                addListener(object : Animator.AnimatorListener{
//                    override fun onAnimationStart(animation: Animator?) {
//                        log("===onAnimationStart===")
//                    }
//
//                    override fun onAnimationEnd(animation: Animator?) {
//                        log("===onAnimationEnd===")
//                    }
//
//                    override fun onAnimationCancel(animation: Animator?) {
//                        log("===onAnimationCancel===")
//                    }
//
//                    override fun onAnimationRepeat(animation: Animator?) {
//                        log("===onAnimationRepeat===")
//                    }
//
//                })
//                addUpdateListener {it1->
//                    log("===onAnimationUpdate===${it1.animatedValue}")
//                }
//                start()
//            }
        }

//        val path = Path().apply {
//            arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true)
//        }
//        val animator = ObjectAnimator.ofFloat(it, View.ALPHA ,View.ALPHA, path).apply {
//            duration = 2000
//            start()
//        }


















        val transition= ResourcesCompat.getDrawable(
                resources,
                R.drawable.expand_collapse,
                null
            ) as TransitionDrawable

            val image: ImageView = findViewById(R.id.toggle_image)
            image.setImageDrawable(transition)

            // Description of the initial state that the drawable represents.
            // Then you can call the TransitionDrawable object's methods.
            transition.startTransition(5000)

    }
}