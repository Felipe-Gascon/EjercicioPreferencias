package com.example.felip.ejerciciopreferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton masc, fem;
    EditText nom,dni,nac;
    Button guarda;
    public static String pref= "Preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        masc = (RadioButton)findViewById(R.id.rb_masc);
        fem=(RadioButton)findViewById(R.id.rb_fem);
        nom=(EditText)findViewById(R.id.et_nom);
        dni=(EditText)findViewById(R.id.et_dni);
        nac=(EditText)findViewById(R.id.et_nac);
        guarda=(Button)findViewById(R.id.btn_guarda);
        guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                guardaDatos();
                startActivityForResult(intent,1);

            }
        });
    }




    public void guardaDatos(){
        SharedPreferences mySharedPreferences =getSharedPreferences(pref,MODE_PRIVATE);
        SharedPreferences.Editor editor=mySharedPreferences.edit();

        String nombre = nom.getText().toString();
        String docum = dni.getText().toString();
        String fnac = nac.getText().toString();
        if(masc.isChecked())
        {
            String sex = "Masculino";
            editor.putString("sexoM",sex);

        }else {
            if (fem.isChecked()) {
                String sexFem="Femenino";
                editor.putString("sexoF",sexFem);
            }
        }
        editor.putString("nombre",nombre);
        editor.putString("documento",docum);
        editor.putString("nacimiento",fnac);

        //guardamos los datos
        editor.commit();
    }
}
