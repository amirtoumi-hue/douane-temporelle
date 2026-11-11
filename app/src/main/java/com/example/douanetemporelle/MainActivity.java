package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Toumi Amir - Groupe 03
public class MainActivity extends AppCompatActivity {

    // 1) تعريف عناصر الواجهة
    private EditText etNom, etNaissance, etDestination;
    private Spinner spMotif;
    private Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) ربط العناصر بالـ XML عبر الـ id
        etNom = findViewById(R.id.et_nom_ta);
        etNaissance = findViewById(R.id.et_naissance_ta);
        etDestination = findViewById(R.id.et_destination_ta);
        spMotif = findViewById(R.id.sp_motif_ta);
        btnInspecter = findViewById(R.id.btn_inspecter_ta);

        // 3) عند الضغط على الزر
        btnInspecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 4) قراءة القيم المدخلة
                String nom = etNom.getText().toString().trim();
                String naissance = etNaissance.getText().toString().trim();
                String destination = etDestination.getText().toString().trim();
                String motif = spMotif.getSelectedItem().toString();

                // 5) التحقق من أن الحقول غير فارغة
                if (nom.isEmpty() || naissance.isEmpty() || destination.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // 6) إنشاء Intent صريح نحو النشاط الثاني
                Intent intent = new Intent(MainActivity.this, VerificationActivity.class);

                // 7) إرسال البيانات بمفاتيح مبنية بالدالة الثابتة
                String m = Cles.MATRICULE;
                intent.putExtra(Cles.nomVoyageur(m), nom);
                intent.putExtra(Cles.anneeNaissance(m), Integer.parseInt(naissance));
                intent.putExtra(Cles.anneeDestination(m), Integer.parseInt(destination));
                intent.putExtra(Cles.motif(m), motif);

                // 8) تشغيل النشاط الثاني
                startActivity(intent);
            }
        });
    }
}