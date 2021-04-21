package co.edu.udea.compumovil.gr05_20211.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        print("----------------------------------------------------------------------")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "Pagina Principal"

        val personalDataBtn: Button = findViewById(R.id.btnInicio)
        personalDataBtn.setOnClickListener {
            val intent = Intent(this, ContactDataActivity::class.java)
            startActivity(intent)
        }
    }
}