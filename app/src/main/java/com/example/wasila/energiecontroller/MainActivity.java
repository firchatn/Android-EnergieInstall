package com.example.wasila.energiecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String user = "root";
    private static String pass = "root";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



        public void sendMessage (View view){
            TextView msgv1 = (TextView) findViewById(R.id.msglogin);

            EditText text1 = (EditText) findViewById(R.id.username);
            String userName = text1.getText().toString();
            EditText text2 = (EditText) findViewById(R.id.password);
            String passWord = text2.getText().toString();
            System.out.println(userName);
            System.out.println(passWord);
            if ( userName.equals(user) && passWord.equals(pass)) {
                Intent intent = new Intent(this, SendMessageActivity.class);
                startActivity(intent);
            }
            else{
                msgv1.setText("Username or password invalid ! ");
            }

    }


}
