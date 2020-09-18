package app.babachan.l4s_savedata

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStore: SharedPreferences = getSharedPreferences("DateStore", Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            val stringText = editText.text.toString()
            saveText.text = stringText
            val editor = dataStore.edit()
            editor.putString("Input", stringText)
            editor.apply()
        }

        readButton.setOnClickListener {
            val str = dataStore.getString("Input", "NoData")
            readText.text = str
        }
    }
}