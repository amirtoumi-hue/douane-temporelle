package com.example.douanetemporelle;

// Toumi Amir - Groupe 03

public class Cles {


    // monsieur me3tawnewnech el carte etud 7atit 1234
    public static final String MATRICULE = "1234";

    // NSN3OU CLE NL MQTRICULE
    public static String construire(String matricule, String champ) {
        return matricule + "_" + champ;
    }

    // CLE NOM VOYAGEUR
    public static String nomVoyageur(String matricule) {
        return construire(matricule, "NOM_VOYAGEUR");
    }

    // CLE DATE NEC
    public static String anneeNaissance(String matricule) {
        return construire(matricule, "ANNEE_NAISSANCE");
    }

    // CLE ANNE DEST
    public static String anneeDestination(String matricule) {
        return construire(matricule, "ANNEE_DESTINATION");
    }

    // 3LCH MSEFR
    public static String motif(String matricule) {
        return construire(matricule, "MOTIF");
    }

    // ACCEPTE WALLA LE
    public static String verdict(String matricule) {
        return construire(matricule, "VERDICT");
    }
}