package com.developer.statelivedata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.developer.statedata.addText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val t = findViewById<TextView>(R.id.texView)
        t.addText("Hi")

        t.setOnClickListener {
            t.addText("Success")
        }*/

    }
}