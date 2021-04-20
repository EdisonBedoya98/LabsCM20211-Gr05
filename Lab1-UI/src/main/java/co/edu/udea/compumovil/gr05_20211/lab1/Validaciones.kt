package co.edu.udea.compumovil.gr05_20211.lab1

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

class Validaciones {

    fun isEmail(cadena: String?): Boolean {
        val resultado: Boolean
        resultado = Patterns.EMAIL_ADDRESS.matcher(cadena).matches()
        return resultado
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
}