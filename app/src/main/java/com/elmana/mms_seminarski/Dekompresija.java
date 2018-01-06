package com.elmana.mms_seminarski;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dekompresija extends AppCompatActivity {

    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dekompresija);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void dekompresija(View view) {
        text = (EditText) findViewById(R.id.editText3);
        LZW lzw = new LZW();
        List<String> splitaniString1 = Arrays.asList(text.getText().toString().split("\\s*,\\s*"));
        List<Integer> kompresovanText = new ArrayList<Integer>();
        for (Integer i = 0; i < splitaniString1.size(); i++) {
            String s = splitaniString1.get(i).replaceAll("[\\[\\](){}]", "");
            kompresovanText.add(Integer.valueOf(s));
        }
        String dekomprenosovanText = lzw.decompress(kompresovanText);
        Toast.makeText(getApplicationContext(), "Dekompresovana poruka glasi: " + dekomprenosovanText, Toast.LENGTH_LONG).show();
    }

}
