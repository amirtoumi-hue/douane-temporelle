package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Toumi Amir - Groupe 03
public class VerificationActivity extends AppCompatActivity {

    private TextView tvNom, tvAge, tvMotif, tvAlerte;
    private Button btnApprouver, btnRefuser;


    private String nom, motif;
    private int naissance, destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        // liaison
        tvNom = findViewById(R.id.tv_nom_ta);
        tvAge = findViewById(R.id.tv_age_ta);
        tvMotif = findViewById(R.id.tv_motif_ta);
        tvAlerte = findViewById(R.id.tv_alerte_ta);
        btnApprouver = findViewById(R.id.btn_approuver_ta);
        btnRefuser = findViewById(R.id.btn_refuser_ta);

        // njib el data nl intent
        String m = Cles.MATRICULE;
        Intent recu = getIntent();
        nom = recu.getStringExtra(Cles.nomVoyageur(m));
        motif = recu.getStringExtra(Cles.motif(m));
        naissance = recu.getIntExtra(Cles.anneeNaissance(m), 0);
        destination = recu.getIntExtra(Cles.anneeDestination(m), 0);

        // calcul
        int ageTemporel = destination - naissance;

        // el resume
        tvNom.setText("Nom : " + nom);
        tvAge.setText("Âge temporel : " + ageTemporel + " ans");
        tvMotif.setText("Motif : " + motif);

        // raison logique
        if (motif.equals("Modification du passé") && estPremier(ageTemporel)) {
            btnApprouver.setEnabled(false);
            tvAlerte.setText("⚠ Paradoxe détecté : approbation impossible");
        }

        // confirmation vqlidee
        btnApprouver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lancerVerdict(true);
            }
        });

        // non validee
        btnRefuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lancerVerdict(false);
            }
        });
    }


    private void lancerVerdict(boolean approuve) {
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        intent.putExtra(Cles.verdict(Cles.MATRICULE), approuve);
        intent.putExtra(Cles.nomVoyageur(Cles.MATRICULE), nom);
        startActivity(intent);
    }

    private boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}