package com.example.felip.ejerciciopreferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends MainActivity {
    TextView nom,docum,fNacimiento,sexo, sexoF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        nom=(TextView)findViewById(R.id.tv_nombre);
        docum=(TextView)this.findViewById(R.id.tv_doc);
        fNacimiento=(TextView)this.findViewById(R.id.tv_Fnac);
        sexo=(TextView)this.findViewById(R.id.tv_sexoM);
        sexoF=(TextView)findViewById(R.id.tv_sexoF);
        recuperaDatos();



    }


    public void recuperaDatos(){
        SharedPreferences sharedPreferences = getSharedPreferences(pref, Activity.MODE_PRIVATE);
        String nombre = sharedPreferences.getString("nombre","");
        String dni = sharedPreferences.getString("documento","");
        String fNac = sharedPreferences.getString("nacimiento","");
        String sexo1 =sharedPreferences.getString("sexoM","");
        String sexo2 =sharedPreferences.getString("sexoF","");

        nom.setText(nombre);
        docum.setText(dni);
        fNacimiento.setText(fNac);
        if(!sexo1.isEmpty()&&sexo2.isEmpty()){
            sexo.setText(sexo1);

        }else {
            if(sexo1.isEmpty()&&!sexo2.isEmpty()){
                sexo.setText(sexo2);
            }
        }


    }

}
