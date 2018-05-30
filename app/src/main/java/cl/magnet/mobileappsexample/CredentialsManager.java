package cl.magnet.mobileappsexample;

import android.content.Context;
import android.content.SharedPreferences;

public class CredentialsManager {

    private static final String CREDENTIALS_PREFERENCES_FILE = CredentialsManager.class.toString()
            + ".credentials";
    private Context context;

    public CredentialsManager(Context context){
        this.context = context;
    }

    public void storeToken(String token){
        SharedPreferences preferences = getPreferences();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);
        editor.apply();
    }

    public String getToken(){
        SharedPreferences preferences = getPreferences();

        return preferences.getString("token", "");
    }

    public String getUsername(){
        SharedPreferences preferences = getPreferences();

        return preferences.getString("username", "");
    }

    public String getPassword(){
        SharedPreferences preferences = getPreferences();

        return preferences.getString("password", "");
    }

    public void storeCredentials(String username, String password){
        SharedPreferences preferences = getPreferences();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public boolean isUserLoggedIn(){

        SharedPreferences preferences = getPreferences();
        String username = preferences.getString("username", "");

        return !username.equals("");
    }

    public void logoutUser(){
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    private SharedPreferences getPreferences(){
         return context.getSharedPreferences(
                CREDENTIALS_PREFERENCES_FILE, Context.MODE_PRIVATE);
    }
}
