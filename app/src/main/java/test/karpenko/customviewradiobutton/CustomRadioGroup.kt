package test.karpenko.customviewradiobutton

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.Exception
import kotlin.math.log


class CustomRadioGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr){
    private val root: ConstraintLayout by lazy { this.findViewById(R.id.constraintLayout) }
    private val radioButton: RadioButton by lazy { this.findViewById(R.id.radioButton) }
    private val radioButton2: RadioButton by lazy { this.findViewById(R.id.radioButton2) }
    private val radioButton3: RadioButton by lazy { this.findViewById(R.id.radioButton3) }
    private val radioButton4: RadioButton by lazy { this.findViewById(R.id.radioButton4) }

    private var onClick: OnRadioButtonClick? = null
    fun setCallBack(onRadioButtonClick: OnRadioButtonClick){
        onClick = onRadioButtonClick
    }

    init {

        View.inflate(getContext(), R.layout.activity_custom_radio_group2, this)
        val arr = context.obtainStyledAttributes(attrs, R.styleable.CustomRadioGroup,0,0)

        try {
            val radioButtonText = arr.getString(R.styleable.CustomRadioGroup_radioButton)
            val radioButton2Text = arr.getString(R.styleable.CustomRadioGroup_radioButton2)
            val radioButton3Text = arr.getString(R.styleable.CustomRadioGroup_radioButton3)
            val radioButton4Text = arr.getString(R.styleable.CustomRadioGroup_radioButton4)

            radioButton.text = radioButtonText
            radioButton2.text = radioButton2Text
            radioButton3.text = radioButton3Text
            radioButton4.text = radioButton4Text
        }catch (exception: Exception){
            Log.d("TAG", exception.printStackTrace().toString())
        }finally {
            arr.recycle()
        }

        showView()
    }

    fun setTextRadioButtonOne(string: String){
        radioButton.text = string
    }

    fun setTextRadioButtonTwo(string: String){
        radioButton2.text = string
    }

    fun setTextRadioButtonThree(string: String){
        radioButton3.text = string
    }

    fun setTextRadioButtonFour(string: String){
        radioButton4.text = string
    }

    private fun showView() {
        radioButton.setOnClickListener {
                radioButton.isChecked = true
                radioButton2.isChecked = false
                radioButton3.isChecked = false
                radioButton4.isChecked = false
            onClick?.onClick(radioButton.text.toString())
        }
        radioButton2.setOnClickListener {
                radioButton.isChecked = false
                radioButton2.isChecked = true
                radioButton3.isChecked = false
                radioButton4.isChecked = false
            onClick?.onClick(radioButton2.text.toString())
        }
        radioButton3.setOnClickListener {
                radioButton.isChecked = false
                radioButton2.isChecked = false
                radioButton3.isChecked = true
                radioButton4.isChecked = false
            onClick?.onClick(radioButton3.text.toString())
        }
        radioButton4.setOnClickListener {
                radioButton.isChecked = false
                radioButton2.isChecked = false
                radioButton3.isChecked = false
                radioButton4.isChecked = true
            onClick?.onClick(radioButton4.text.toString())
        }
    }
}