package com.example.matatena;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveCoins {

   //Nombre del archivo de Preferencias
    private static final String PREFS_NAME = "MyPrefsFile";

    //Variable para guardar
    public static final String COINS = "coins";

    //Guarda un entero, que son las monedas
    public static void saveInteger(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    // Devuelve el entero de SharedPreferences
    public static int getSavedInteger(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        // Valor por defecto es 0 si no se encuentra el valor asociado a la clave
        return sharedPreferences.getInt(key, 0);
    }

    //Resetear datos de las Preferencias
    public static void clearAllPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
