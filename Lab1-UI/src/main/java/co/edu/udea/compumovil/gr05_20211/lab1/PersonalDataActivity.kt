package co.edu.udea.compumovil.gr05_20211.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PersonalDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        val actionBar = supportActionBar
        actionBar!!.title = "Información Personal"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}