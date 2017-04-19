package com.example.firas.energie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static String email1 = "firaschaabencss@gmail.com";
    private static String subject = "Full energie";
    private String body ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void send(View view) {
        EditText text = (EditText)findViewById(R.id.mat);
        String matricule = text.getText().toString();
        String energie;
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.d);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.e);
        if (checkBox1.isChecked()) {
            energie = "Diesel";
        }
        else if (checkBox2.isChecked()) {
            energie = "Essance";
        } else {
            energie = "<Inconnue>";
        }
        EditText text2 = (EditText)findViewById(R.id.quantite);
        String quantite = text2.getText().toString();

        Calendar c = Calendar.getInstance();

        body =  "La matricule " + matricule + " a installe " + quantite + "L d'energie " + energie +
                " le " + c.getTime().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email1});
        i.putExtra(Intent.EXTRA_SUBJECT, "[" + matricule + "] " + subject );
        i.putExtra(Intent.EXTRA_TEXT   , body);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }


    }

}
