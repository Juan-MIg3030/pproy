package com.stdevs.practicaj

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class LaActividad2 : AppCompatActivity() {
    var spinner: Spinner? =null
    var listaView:ListView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_la_actividad2)

        spinner=findViewById(R.id.spinner)
        listaView=findViewById(R.id.listaView)

        paraSpinner()
        paraLista()


        var bundle=intent.extras
        var infoBund = bundle?.getString("llave")

        val preferencias =this.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        var prefleida: String? =preferencias.getString("llave2", "NO")

        var res:String=infoBund+"\n"+prefleida

        Toast.makeText(this, res, Toast.LENGTH_LONG).show()

    }

    private fun paraLista() {
        var adaptador:ArrayAdapter<*>
        var personas = mutableListOf("alvaro", "antonio", "reyes", "linares")

        adaptador=ArrayAdapter(this, android.R.layout.simple_list_item_1, personas)
        listaView?.adapter=adaptador
    }

    private fun paraSpinner() {
        val lista =resources.getStringArray(R.array.opciones_spinner)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner?.adapter=adaptador

        spinner?.onItemSelectedListener=object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, lista[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun onClick(view: android.view.View) {
        when(view.id){
            R.id.btBack->{
                var intent2 = Intent(this, MainActivity::class.java)
                startActivity(intent2)
            }
        }


    }
}