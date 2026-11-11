package com.example.douanetemporelle;

// Toumi Amir - Groupe 03
// 1) هذا الصنف مسؤول عن بناء مفاتيح الـ putExtra
public class Cles {


    // 2) المصفوفة الثابتة: الأرقام الأربعة الأخيرة من بطاقة الطالب (بدّلها برقمك)
    // monsieur me3tawnewnech el carte etud 7atit 1234
    public static final String MATRICULE = "1234";

    // 3) دالة ثابتة عامة تبني المفتاح انطلاقا من المطريكول واسم الحقل
    public static String construire(String matricule, String champ) {
        return matricule + "_" + champ;
    }

    // 4) مفتاح اسم المسافر
    public static String nomVoyageur(String matricule) {
        return construire(matricule, "NOM_VOYAGEUR");
    }

    // 5) مفتاح سنة الميلاد
    public static String anneeNaissance(String matricule) {
        return construire(matricule, "ANNEE_NAISSANCE");
    }

    // 6) مفتاح سنة الوجهة
    public static String anneeDestination(String matricule) {
        return construire(matricule, "ANNEE_DESTINATION");
    }

    // 7) مفتاح سبب السفر
    public static String motif(String matricule) {
        return construire(matricule, "MOTIF");
    }

    // 8) مفتاح الحكم النهائي (قبول / رفض)
    public static String verdict(String matricule) {
        return construire(matricule, "VERDICT");
    }
}