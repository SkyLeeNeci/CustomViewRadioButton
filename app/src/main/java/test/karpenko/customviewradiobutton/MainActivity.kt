package test.karpenko.customviewradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import test.karpenko.customviewradiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customRadioGroup.setCallBack(object : OnRadioButtonClick {
            override fun onClick(string: String) {
                Toast.makeText(this@MainActivity, string, Toast.LENGTH_SHORT).show()
            }
        })

        binding.customRadioGroup.setOnClickListener {
            binding.customRadioGroup.setTextRadioButtonOne("1")
            binding.customRadioGroup.setTextRadioButtonTwo("2")
            binding.customRadioGroup.setTextRadioButtonThree("3")
            binding.customRadioGroup.setTextRadioButtonFour("4")
        }

    }
}