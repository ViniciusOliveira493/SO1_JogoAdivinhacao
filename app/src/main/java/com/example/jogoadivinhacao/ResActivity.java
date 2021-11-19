package com.example.jogoadivinhacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResActivity extends AppCompatActivity {
    private Button btnVoltar;
    private TextView txtConclusao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        txtConclusao = (TextView) findViewById(R.id.txtConclusao);

        receberNumero();
        btnVoltar.setOnClickListener(x -> voltar());
    }

    private void receberNumero() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int numRandom = bundle.getInt("numRandom");
        txtConclusao.setText(getString(R.string.parabens)+" "+numRandom);
    }

    private void voltar() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}