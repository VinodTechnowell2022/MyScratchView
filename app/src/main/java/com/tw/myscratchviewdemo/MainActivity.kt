package com.tw.myscratchviewdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tw.myscratchviewdemo.utils.ScratchView
import com.tw.myscratchviewdemo.utils.ScratchView.IRevealListener


class MainActivity : AppCompatActivity() {

    lateinit var scratchView: ScratchView
    lateinit var mask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mask = findViewById(R.id.mask)
        scratchView = findViewById(R.id.scratch_view)

        scratchView.setRevealListener(object : IRevealListener {
            override fun onRevealed(scratchView: ScratchView) {
                Toast.makeText(applicationContext, "Reveled", Toast.LENGTH_LONG).show()
            }

            override fun onRevealPercentChangedListener(scratchView: ScratchView, percent: Float) {
                if (percent >= 0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: $percent")
                }
            }
        })

        mask.setOnClickListener { v: View? -> scratchView.mask() }
    }


}