package com.elmana.mms_seminarski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText text;
    EditText broj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendSMSMessage(View view) {
        broj = (EditText) findViewById(R.id.editText2);
        text = (EditText) findViewById(R.id.editText);
        LZW lzw = new LZW();
        Log.i("text", text.getText().toString());
        List<Integer> compressed = lzw.compress(text.getText().toString());
        String phoneNo = broj.getText().toString();
        String message = compressed.toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS poslan.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS nije poslan, pokušajte ponovo.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void otvoriDekompresujProzor(View view){
        Intent i = new Intent(MainActivity.this, Dekompresija.class);
        startActivity(i);
    }

}
