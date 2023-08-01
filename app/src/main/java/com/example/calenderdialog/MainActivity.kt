package com.example.calenderdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calenderdialog.databinding.ActivityMainBinding
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val calenderDialog = CalenderDialog()
        binding.btnCalenderDialog.setOnClickListener {
            //binding.flCalender.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.to_up, R.anim.from_down)
                .replace(R.id.fl_calender, calenderDialog)
                .commitAllowingStateLoss()

            binding.btnCalenderDialog.visibility = View.GONE
        }
        calenderDialog.setOnButtonClickListener(object : CalenderDialog.OnButtonClickListener{
            override fun onButtonClicked(date: String) {
                binding.tvDate.text = date
                supportFragmentManager.beginTransaction()
                    .remove(calenderDialog)
                    .commit()
                binding.btnCalenderDialog.visibility = View.VISIBLE
            }
        })
    }
}