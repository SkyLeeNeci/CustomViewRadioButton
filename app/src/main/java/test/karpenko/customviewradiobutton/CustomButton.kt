package test.karpenko.customviewradiobutton

import android.content.Context
import android.graphics.drawable.Drawable
import android.provider.ContactsContract
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.Exception

class CustomButton@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr) {
    private val root: ConstraintLayout by   lazy { findViewById(R.id.customBtnRoot) }
    private val texView: TextView by lazy { this.findViewById(R.id.textView) }
    private val imageView: ImageView by lazy { findViewById(R.id.imageView) }


    init {

        View.inflate(getContext(), R.layout.custom_button, this)
        val arr = context.obtainStyledAttributes(attrs, R.styleable.CustomButton,0,0)

        try {
            val text = arr.getString(R.styleable.CustomButton_textViewText)
            val image = arr.getDrawable(R.styleable.CustomButton_src)

            texView.text = text
            imageView.setImageDrawable(image)

        }catch (exception: Exception){
            Log.d("TAG", exception.printStackTrace().toString())
        }finally {
            arr.recycle()
        }

        showView()

    }

    private fun showView(){
        root.setOnLongClickListener {
            texView.text = "LONG"
            root.setBackgroundColor(resources.getColor(R.color.purple_200))
            true
        }

        root.setOnClickListener {
            texView.text = "CLICK"
            root.setBackgroundColor(resources.getColor(R.color.teal_700))
        }
    }

    fun setText(text:String){
        texView.text = text
    }

    fun setImage(image: Int){
        imageView.setImageResource(image)
    }

}