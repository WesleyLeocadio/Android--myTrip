package com.devwesley.sistema

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var params = intent.extras
        var texto = params?.getString("Usuario")
        textMensagem.text = texto.toString()
        button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        if(id==R.id.button){
            var i = Intent()
            i.putExtra("DADOS_RESPOSTA", "Deu certo!")
            setResult(Activity.RESULT_OK, i)
            finish()

        }



    }
}
