package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    EditText editext;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Widgets
        textview = findViewById(R.id.textView);
        editext = findViewById(R.id.editName);
        btn = findViewById(R.id.button);


        //onClick Función para capturar el nombre que el usuario a ingresado y pasarlo a la
        //siguiente pantalla
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //explicit Intent para cambiar de pantalla
                Intent I = new Intent(getApplicationContext(), LuckyNumberActivity.class);


                //Pasando la data del nombre a la siguiente pantalla
                String user_name = editext.getText().toString();
                I.putExtra("name", user_name);

                //Correr el explicit Intent
                startActivity(I);
            }
        });
    }


}