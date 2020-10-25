package com.gerva.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class infoContacto extends AppCompatActivity {

    //Declaro mis objetos, utilizando los id de mi archivo xml//

    private TextView tvNombreContacto,tvTelefonoCont, tvEmailCont, tvDescripcionCont, tvFechaNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Casteo de objetos//

        tvNombreContacto = (TextView)findViewById(R.id.tvNombreContacto);
        tvFechaNac = (TextView)findViewById(R.id.tvFechaNac);
        tvTelefonoCont = (TextView)findViewById(R.id.tvTelefonoCont);
        tvEmailCont = (TextView)findViewById(R.id.tvEmailCont);
        tvDescripcionCont = (TextView)findViewById(R.id.tvDescripcionCont);

        //Para alojar los datos enviados desde el otro activity creo variables String//
        String nombreCont = getIntent().getStringExtra("nombre");
        tvNombreContacto.setText(nombreCont);
        String fechaCont = getIntent().getStringExtra("fecha");
        tvFechaNac.setText("Fecha de nacimiento: "+ fechaCont);
        String teleCont = getIntent().getStringExtra("telefono");
        tvTelefonoCont.setText("Teléfono: " + teleCont);
        String emailCont = getIntent().getStringExtra("email");
        tvEmailCont.setText("email: "+ emailCont);
        String descrCont = getIntent().getStringExtra("descrip");
        tvDescripcionCont.setText("Descripción: " + descrCont);


    }

    //Método para el botón Editar Datos//
    //Tengo que probar solamente asignarle una funciòn de back para voler a editar//
    public void EditarDatos(View view) {
        Intent editarDatos = new Intent(this, MainActivity.class);
        startActivity(editarDatos);

        }
    }