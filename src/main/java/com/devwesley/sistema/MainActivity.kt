package com.devwesley.sistema

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val MY_RESULT_CODE = 99
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        val id: Int = view.id
        if (id == R.id.button) {
            if (verificarCampos()) {
                if (editUsuario.text.toString() == "wesley" && editSenha.text.toString() == "admin") {
                    Toast.makeText(this, "Entrou", Toast.LENGTH_SHORT).show()
                    var i = Intent(this, Main2Activity::class.java)
                    var b = Bundle()
                    var p:Pessoa =  Pessoa(editUsuario.text.toString(),editSenha.text.toString())
                    b.putString("Usuario", editUsuario.text.toString())
                    b.putString("Senha", editSenha.text.toString())

                    i.putExtras(b)
                  //  startActivity(i)
                    startActivityForResult(i,MY_RESULT_CODE)
                } else {
                    Toast.makeText(this, "Dados incorretos!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preenchar todos os campos", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun verificarCampos():Boolean {
        return editUsuario.text.toString() != "" &&
                editSenha.text.toString() != ""
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            MY_RESULT_CODE -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        Toast.makeText(this, "Clicou no botão", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

 }




