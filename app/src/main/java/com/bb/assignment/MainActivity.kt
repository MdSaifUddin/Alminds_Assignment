package com.bb.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.bb.assignment.databinding.ActivityMainBinding
import android.widget.TableLayout
import android.view.animation.ScaleAnimation







class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var count=MutableLiveData<Int>(1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        initialize()
    }
    fun initialize(){
        binding.add.setOnClickListener {
            count.postValue(count.value!!.toInt()+1)
        }

        binding.subtract.setOnClickListener {
            count.postValue(count.value!!.toInt()-1)
        }
        count.observe(this,{
            if(it==1){
                binding.delete.visibility= View.VISIBLE
                binding.subText.text="Remove"
            }else{
                binding.delete.visibility= View.GONE
                binding.subText.text="-\nLess"
            }

            if(it>=0)
                binding.text.text="${count.value}"

            if(it<1){
                binding.subtract.visibility=View.GONE
                binding.text.visibility=View.GONE
                binding.add.text="Add to cart"
            }else{
                binding.subtract.visibility=View.VISIBLE
                binding.text.visibility=View.VISIBLE
                binding.add.text="+\nMore"
            }
        })

        count.postValue(1)
    }
}