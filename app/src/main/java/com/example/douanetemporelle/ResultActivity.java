package com.example.douanetemporelle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Toumi Amir - Groupe 03
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //liaison
        LinearLayout racine = findViewById(R.id.layout_racine_ta);
        TextView tvMessage = findViewById(R.id.tv_message_ta);
        Button btnNouveau = findViewById(R.id.btn_nouveau_ta);

        // njib el esm wl 9arar
        Intent recu = getIntent();
        boolean approuve = recu.getBooleanExtra(Cles.verdict(Cles.MATRICULE), false);
        String nom = recu.getStringExtra(Cles.nomVoyageur(Cles.MATRICULE));

        // loun el bg 7asb el 9arar
        if (approuve) {
            racine.setBackgroundColor(Color.parseColor("#2E7D32")); // أخضر
            tvMessage.setText("Bon voyage " + nom + " !");
        } else {
            racine.setBackgroundColor(Color.parseColor("#C62828")); // أحمر
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
        }

        // rjou3 lil main
        btnNouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}