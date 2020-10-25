package com.gerva.week1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView fecha;
    Button boton;
    private EditText etnom, ettel, etmail, etdescr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seteando el toolbar creado para sutituir el actionbar//
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //seteando el Datepicker//
        datePicker = (DatePicker) findViewById(R.id.datepicker);
        fecha = (TextView) findViewById(R.id.tvDate);;
        boton = (Button) findViewById(R.id.datebutton);;
        boton.setOnClickListener(new View.OnClickListener(){

            //Con este método voy a tomar los datos del datepicker y mandarlos a un textView//
            @Override
            public void onClick(View v) {
                //Para obtener los datos de fecha transformamos a string esos valores//
                fecha.setText(String.valueOf(datePicker.getDayOfMonth()+ "/" +
                                String.valueOf(datePicker.getMonth()+ "/" +
                                String.valueOf(datePicker.getYear())

                                )
                        )
                );

            }
        });

        //Casteando datos contactos, conexion de gráfica con la lógica//
        etnom = (EditText) findViewById(R.id.edtnombre);
        ettel = (EditText) findViewById(R.id.edttelefono);
        etmail = (EditText) findViewById(R.id.edtemail);
        etdescr = (EditText) findViewById(R.id.edtdescripcion);


    }

     // método para el botón siguiente. Creando un objeto del tipo View//
    public void Siguiente(View view){
        //Creo un objeto del tipo Intent (siguiente) para pasar de una pantalla a otra indicandolo de donde (this) y
        //hacia donde voy//
        Intent siguiente = new Intent(this,infoContacto.class);
        //Utilizo el método putExtra para enviar valores al segundo activity, para este ejemplo lo convierto en string//
        siguiente.putExtra("nombre",etnom.getText().toString());
        siguiente.putExtra("telefono",ettel.getText().toString());
        siguiente.putExtra("email",etmail.getText().toString());
        siguiente.putExtra("descrip",etdescr.getText().toString());
        siguiente.putExtra("fecha",fecha.getText().toString());
        startActivity(siguiente);

    }


}