package com.stdevs.practicaj

import android.content.Context
import android.content.Intent
import android.media.MediaCodec.MetricsConstants.MODE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClick(view: android.view.View) {
        when(view.id){
            R.id.bt1->{
                var res:Int = iterar(2, 3)
                Toast.makeText(applicationContext, res.toString(), Toast.LENGTH_LONG).show()

            }

            R.id.bt2->{
                arreglos()
            }

            R.id.bt3->{
                listas()
            }

            R.id.bt4->{
                mapas()
            }

            R.id.bt5->{
                pasarActividades()
            }
        }
    }

    private fun pasarActividades() {
        val intent1 = Intent(this, LaActividad2::class.java)
        intent1.putExtra("llave", "valor bundle")
        startActivity(intent1)

        val preferencias =this.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        preferencias.edit().putString("llave2", "valor prefs").apply()
    }

    private fun mapas() {
        val mapa1 = mapOf<Int, String>(1 to "juan", 2 to "pablo", 3 to "seb")
        var mapa2= mutableMapOf<String, String>("primero" to "antonio", "segundo" to "fernando", "tercero" to "sergio")

        mapa2.keys //solo llaves
        mapa2.values // solo valores

        mapa2["cuarto"]="ivan"

        mapa2.put("quinto", "jhoana")
        mapa2.set("sexto", "paola")
        mapa2.replace("sexto", "tania")
        mapa2.replace("sexto", "tania", "paola")
        mapa2.remove("primero")

        if("sexto" in mapa2){}

        if ("juan" in mapa1.values){}

        if (mapa1.containsKey(3)){}

        if(mapa1.containsValue("juan")){}
    }

    private fun listas() {
        val lista1= listOf<String>("1", "2", "3", "4", "5")
        var lista2 = mutableListOf<String>()

        lista1.count()//tamaño de la lista
        lista2.add(0, "d")

        lista2[1]=lista1[1]
        lista2.remove("2")
        lista2.removeAt(0)
        lista2.addAll(lista1)

        lista1.get(1)
        lista2.clear()//elimina toda la lista



        for(i in lista1){

        }
    }

    private fun arreglos() {
        val a2 = arrayOf("a", "b", "c")
        val a3 = arrayOfNulls<String>(3)
        var res = ""

        val a4 = Array(2) { IntArray(2) }
        val a5 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

        a4[0][0] = 1

        for (i in a3.indices) {
            a3[i] = a2[i]
            //res = """$res${a3[i]}""".trimIndent()
            res = res +a3[i]+"\n";
            //Toast.makeText(applicationContext, res, Toast.LENGTH_LONG).show()
            Toast.makeText(applicationContext, a4[0][0].toString(), Toast.LENGTH_LONG).show()
            a3.set(2,"m")
        }
    }


    fun iterar(vE1:Int, vE2:Int):Int{
        var v1=vE1
        var v2=vE2
        var sum: Int =0

        for(j in 0..v1){ //until, downto
            for(i in 0..v2){
                sum+=v2
            }
        }

        return sum
    }
}