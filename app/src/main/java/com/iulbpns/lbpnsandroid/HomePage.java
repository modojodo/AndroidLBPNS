package com.iulbpns.lbpnsandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asad 15R on 11/26/2015.
 */
public class HomePage extends Activity {

    Button menutabs,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        menutabs = (Button) findViewById(R.id.menutabs);
        menutabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuSelection.class);
                startActivity(intent);
            }
        });

        location = (Button) findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LocationUpdates.class);
                startActivity(intent);
            }
        });
    }
}
