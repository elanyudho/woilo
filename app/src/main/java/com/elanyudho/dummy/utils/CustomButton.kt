package com.elanyudho.dummy.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.elanyudho.dummy.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import id.netara.app.demo.R
import id.netara.app.demo.utils.extension.dp

class CustomButton : ConstraintLayout {

    private lateinit var materialButton: MaterialButton
    private lateinit var shapeableImageView: ShapeableImageView
    private lateinit var progressBar: ProgressBar

    constructor(context: Context, attrs: AttributeSet?): super(context,attrs){
        initView(context,attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr :Int): super(context, attrs, defStyleAttr){
        initView(context,attrs)
    }
    private fun initView(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.layout_custom_button,this)

        materialButton = findViewById(R.id.buttonCustom)
        shapeableImageView = findViewById(R.id.shapeableImageView)
        progressBar = findViewById(R.id.progressBar)

        val attribute = context.obtainStyledAttributes(attrs,R.styleable.CustomButton)


        val isLoading = attribute.getBoolean(R.styleable.CustomButton_isLoading,false)
        val textButton =attribute.getText(R.styleable.CustomButton_text)
        val buttonColor =attribute.getColor(R.styleable.CustomButton_buttonColor,
            ContextCompat.getColor(context,R.color.orange_west_side))
        val textSize = attribute.getInteger(R.styleable.CustomButton_textSizeButton,14)
        val paddingTop = attribute.getDimension(R.styleable.CustomButton_paddingButtonTop,16f)
        val paddingBottom = attribute.getDimension(R.styleable.CustomButton_paddingButtonBottom,16f)
        val paddingLeft = attribute.getDimension(R.styleable.CustomButton_paddingButtonLeft,0f)
        val paddingRight = attribute.getDimension(R.styleable.CustomButton_paddingButtonRight,0f)
        materialButton.text = textButton
        materialButton.setBackgroundColor(buttonColor)

        shapeableImageView.setImageDrawable(setTintButton(shapeableImageView.drawable,buttonColor))

        if(isLoading){
            materialButton.visibility = INVISIBLE
            shapeableImageView.visibility = VISIBLE
            progressBar.visibility = VISIBLE
        }else{
            materialButton.visibility = VISIBLE
            shapeableImageView.visibility = INVISIBLE
            progressBar.visibility = INVISIBLE
        }



        materialButton.textSize = textSize.toFloat()
        if(paddingTop != 16f && paddingBottom!=16f  && paddingLeft !=0f && paddingRight !=0f){
            materialButton.setPadding(paddingLeft.toInt().dp,paddingTop.toInt().dp,paddingRight.toInt().dp,paddingBottom.toInt().dp)
        }


        attribute.recycle()

    }

    fun setTintButton(drawable: Drawable, color :Int): Drawable {
        val wrapDrawable = DrawableCompat.wrap(drawable)
        DrawableCompat.setTint(wrapDrawable,color)
        return wrapDrawable
    }

    fun isLoading(isLoading:Boolean){
        if(isLoading){
            materialButton.visibility = INVISIBLE
            shapeableImageView.visibility = VISIBLE
            progressBar.visibility = VISIBLE
        }else{
            materialButton.visibility = VISIBLE
            shapeableImageView.visibility = INVISIBLE
            progressBar.visibility = INVISIBLE
        }
    }

    fun setOnClickButtonListener(onClick: () -> Unit){
        materialButton.setOnClickListener { onClick() }
    }

    fun setTextButton(text:String){
        materialButton.text = text
    }
}