package co.edu.udea.compumovil.gr05_20211.lab1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ContactDataActivity : AppCompatActivity() {

    private var email : String = ""
    private var telefono : String = ""
    private var pais : String = ""
    private var ciudad : String = ""
    private var direc : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        email = (R.id.textEmail.toString())
        telefono = (R.id.textPhone.toString())
        pais  = (R.id.textPais.toString())
        ciudad =  (R.id.textCiudad.toString())
        direc = (R.id.textDireccion.toString())
    }

    fun valida (view: View){

    }

}




