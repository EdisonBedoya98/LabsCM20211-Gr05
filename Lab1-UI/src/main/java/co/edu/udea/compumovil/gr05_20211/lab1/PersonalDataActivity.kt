package co.edu.udea.compumovil.gr05_20211.lab1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*

class PersonalDataActivity : AppCompatActivity() {

    lateinit var  option : Spinner

    lateinit var txtNombre : EditText
    lateinit var txtApellido : EditText
    lateinit var txtFechaNacimiento : TextView

    lateinit var btnSiguiente : Button
    lateinit var fechaSeleccionada:String
    lateinit var radioButtonHombre : RadioButton
    lateinit var radioButtonMujer : RadioButton

    var year: Int = 0
    var month: Int =0
    var day: Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        val actionBar = supportActionBar
        actionBar!!.title = "Información Personal"

        actionBar.setDisplayHomeAsUpEnabled(true)

        //Open calendar
        val mPickTimeBtn = findViewById<Button>(R.id.change_btn)

        btnSiguiente = findViewById(R.id.btnSiguiente)

        txtNombre = findViewById(R.id.editTextTextPersonName)
        txtApellido = findViewById(R.id.editTextTextPersonLastName)
        txtFechaNacimiento = findViewById(R.id.dateTv)

        radioButtonHombre = findViewById(R.id.radioButtonHombre)
        radioButtonMujer = findViewById(R.id.radioButtonMujer)

        var c = Calendar.getInstance()
        year = c.get(Calendar.YEAR)
        month = c.get(Calendar.MONTH)
        day = c.get(Calendar.DAY_OF_MONTH)


        radioButtonHombre.setOnClickListener{
            if(radioButtonMujer.isChecked) {
                radioButtonMujer.setChecked(false);
            }
        }
        radioButtonMujer.setOnClickListener{
            if(radioButtonHombre.isChecked) {
                radioButtonHombre.setChecked(false);
            }
        }
        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, yearS, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                txtFechaNacimiento.setText(".")
                fechaSeleccionada ="" + dayOfMonth + " " + monthOfYear + ", " + yearS
                this.year = yearS
                this.month = monthOfYear
                this.day = dayOfMonth
            }, year, month, day)

            dpd.show()

        }
        //Boton para cuando se le da click en siguiente validar los campos
      btnSiguiente.setOnClickListener {
            if (TextUtils.isEmpty(txtNombre.text.toString()) || TextUtils.isEmpty(txtApellido.text.toString())
                    || TextUtils.isEmpty(txtFechaNacimiento.text.toString()) ) {

                Toast.makeText(this, "Diligencie los campos obligatorios", Toast.LENGTH_SHORT).show()
                if(TextUtils.isEmpty(txtNombre.text.toString())){
                    txtNombre.setError("Campo Nombre es obligatorio")
                }
                if(TextUtils.isEmpty(txtApellido.text.toString())){
                    txtApellido.setError("Campo Apellido es obligatorio")
                }
                if(TextUtils.isEmpty(txtFechaNacimiento.text.toString())){
                    txtFechaNacimiento.setError("Campo Fecha nacimiento obligatorio")
                }else{
                    txtFechaNacimiento.setError(null)
                }

            } else {
                txtFechaNacimiento.setError(null)
                Log.i("1","Información personal:")
                Log.i("2",txtNombre.text.toString()+" "+ txtApellido.text.toString())
                if(radioButtonHombre.isChecked){
                    Log.i("3","Masculino")
                }
                if(radioButtonMujer.isChecked){
                    Log.i("4","Femenino")
                }
                Log.i("5","Nació el "+day+"/"+month+"/"+year)
                Log.i("6",option.selectedItem.toString())
                Toast.makeText(this, "Todo correctoo", Toast.LENGTH_SHORT).show()




            }
        }
        option = findViewById(R.id.spinner) as Spinner

        val options = arrayOf("","Primaria", "Secundaria", "Universitaria", "Otro")

        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)



    }
}