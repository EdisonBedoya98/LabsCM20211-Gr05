package co.edu.udea.compumovil.gr05_20211.lab1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contact_data.*
import java.util.regex.Matcher
import java.util.regex.Pattern



class ContactDataActivity : AppCompatActivity() {

    private var acPais: AutoCompleteTextView? = null
    private var acCiudad:AutoCompleteTextView? = null
    private var txtTelefono: EditText? = null
    private var txtCorreo:EditText? = null
    private var txtDireccion:EditText? = null
    var btnAtras:Button? = null


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return false;
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        txtTelefono = findViewById(R.id.textPhone)
        txtCorreo = findViewById(R.id.textEmail)
        txtDireccion = findViewById(R.id.textDireccion)
        acPais = findViewById(R.id.autoCompleteTextViewPaises)
        acCiudad = findViewById(R.id.autoCompleteTextViewCiudades)
        val actionBar = supportActionBar

        actionBar!!.title = getString(R.string.contact_name)
        actionBar.setDisplayHomeAsUpEnabled(true)





        var adapterPaises: ArrayAdapter<String> = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countries)
        with(acPais) {
            this?.setAdapter(adapterPaises)
        }
        var adapterCiudades: ArrayAdapter<String> = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,cities)
        with(acCiudad) {
            this?.setAdapter(adapterCiudades)
        }

        val personalDataBtn: Button = findViewById(R.id.btnNext)
        personalDataBtn.setOnClickListener {
            val aux = contactDataActivity()
            if (aux){
                Log.i("Información de Contacto","   ")
                Log.i("Teléfono",txtTelefono?.text.toString())
                Log.i("Dirección",txtDireccion?.text.toString())
                Log.i("Email",txtCorreo?.text.toString())
                Log.i("País",acPais?.text.toString())
                Log.i("Ciudad",acCiudad?.text.toString())


                Toast.makeText(this, getString(R.string.allRight), Toast.LENGTH_SHORT).show()
                /*val intent = Intent(this, DataActivity::class.java)
                startActivity(intent)*/
            }
        }
    }

    private val countries = arrayOf(
        "Colombia",
        "Ecuador",
        "Venezuela",
        "Peru",
        "Bolivia",
        "Paraguay",
        "Brasil",
        "Chile",
        "Uruguay",
        "Argentina"
    )

    private val cities = arrayOf(
        "Bello","Medellin", "Bogota", "Cali", "Barranquilla"
    )
    
    private fun isEmailValid(email: String?): Boolean {
        val pattern = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        )
        val mather: Matcher = pattern.matcher(email)
        val emailValid : Boolean = mather.find()
        if (!emailValid){
            textEmail?.error = getString(R.string.textErrorEmmail)
        }
        return emailValid
    }

    private fun fullField(campo: EditText?, message: Int): Boolean {
        val dato = campo?.text
        return if (TextUtils.isEmpty(dato)) {
            campo?.error = getString(message)
            campo?.requestFocus()
            false
        } else {
            true
        }
    }

    private fun contactDataActivity(): Boolean {
        //var telefono : String = txtTelefono?.text.toString()
        val correo : String = txtCorreo?.text.toString()
        //var direccion : String = txtDireccion?.text.toString()
        //var pais : String = acPais.toString()
        //var ciudad : String = acCiudad.toString()
        var correctField = false
        //var endActivity : Intent = Intent(ContactDataActivity, endActivity.javaClass)

        if (fullField(txtCorreo, R.string.textErrorEmmailVal) and
            fullField(txtTelefono, R.string.emptyField) and
            fullField(acPais, R.string.emptyField) and
            isEmailValid(correo)
        )
        {
            correctField = true
        }
        return correctField
    }


}






