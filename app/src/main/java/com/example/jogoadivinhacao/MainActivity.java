package com.example.jogoadivinhacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numeroDigitado;
    private Button btnTentar;
    private TextView txtDica;
    private int numRandom = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroDigitado = (EditText) findViewById(R.id.txtNumero);
        btnTentar = (Button) findViewById(R.id.btnTentar);
        txtDica = (TextView) findViewById(R.id.txtDica);

        numRandom = (int) ((Math.random()*100)+1);
        btnTentar.setOnClickListener(click -> jogar());
    }

    public void jogar(){
        try{
            int numDigitado = Integer.parseInt(numeroDigitado.getText().toString());

            if(numDigitado > numRandom){
                txtDica.setText(R.string.numeroMenor);
            }else if(numDigitado < numRandom){
                txtDica.setText(R.string.numeroMaior);
            }else if(numDigitado == numRandom){
                fimDeJogo();
            }
        }catch(Exception e){
            Toast toast = Toast.makeText(this,"Você deve digitar um número",Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private void fimDeJogo() {
        Bundle bundle = new Bundle();
        bundle.putInt("numRandom",numRandom);

        Intent intent = new Intent(this, ResActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}