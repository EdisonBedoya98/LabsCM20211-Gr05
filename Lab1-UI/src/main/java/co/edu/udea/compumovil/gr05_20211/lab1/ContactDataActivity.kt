package co.edu.udea.compumovil.gr05_20211.lab1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Matcher
import java.util.regex.Pattern


class ContactDataActivity(correo: String) : AppCompatActivity() {

    var acPais: AutoCompleteTextView? = null
    var acCiudad:AutoCompleteTextView? = null
    var txtTelefono: EditText? = null
    var txtCorreo:EditText? = null
    var txtDireccion:EditText? = null
    var btnSiguiente: Button? = null
    var btnAtras:Button? = null
    var pais: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        txtTelefono = findViewById(R.id.textPhone);
        txtCorreo = findViewById(R.id.textEmail);
        txtDireccion = findViewById(R.id.textDireccion);

    }



    private val countries = arrayOf(
            "Colombia", "Ecuador", "Venezuela", "Peru", "Bolivia", "Paraguay", "Brasil", "Chile", "Uruguay", "Argentina"
    )

    private val cities = arrayOf(
            "Medellin", "Bogota", "Cali", "Barranquilla"
    )
    
    private fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun Vacio(campo: EditText): Boolean {
        val dato = campo.text.toString().trim { it <= ' ' }
        return if (TextUtils.isEmpty(dato)) {
            campo.error = "Campo Requerido"
            campo.requestFocus()
            true
        } else {
            false
        }
    }

    private fun contactDataActivity() {
        var telefono : String = txtTelefono.toString()
        var correo : String = txtCorreo.toString()
        var direccion : String = txtDireccion.toString()
        var pais : String = acPais.toString()
        var ciudad : String = acCiudad.toString()
        var validarEmail : Boolean = isEmailValid(correo)
        var endActivity : Intent = Intent(ContactDataActivity, endActivity.javaClass)

    }


}






