package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView title, result;
    Button btn, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        title = findViewById(R.id.textViewTitle);
        result = findViewById(R.id.textViewResult);
        btn = findViewById(R.id.button2);
        back = findViewById(R.id.buttonAtrás);

        //Incializamos el Intent para obtener la data con el nombre del usuario
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        Toast.makeText(this,"El nombre es "+name, Toast.LENGTH_LONG).show();
        int randomGeneratedNumber = randomNumber();

        result.setText(""+randomGeneratedNumber);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Variable creada para parsea el random numero generado a String
                String num = String.valueOf(randomGeneratedNumber);

                shareData(name, num);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }

    //Función para generar el random numbre
    public int randomNumber(){
        Random r = new Random();

        int number = r.nextInt(1000);

        return number;
    }

    //Función con Intent para compartir el resultado
    public void shareData(String name, String randomNumber){

        //Implicit Intent
        // sd = share data
        Intent sd = new Intent(Intent.ACTION_SEND);

        //Estrableciendo el tipo de dato a enviar
        sd.setType("text/plain");

        //añadiendo la data al intent
        sd.putExtra(Intent.EXTRA_SUBJECT, name+ "got lucky today!");
        sd.putExtra(Intent.EXTRA_TEXT, "His random number is "+randomNumber+"!");

        //Corriendo el Intent
        startActivity(Intent.createChooser(sd, "Share To:"));


    }

    //Función para mostrar menú en el main activity/pantalla principal

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }
}