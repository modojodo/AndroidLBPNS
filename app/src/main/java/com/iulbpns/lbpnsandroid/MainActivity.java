package com.iulbpns.lbpnsandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    EditText etEmail,etPassword;
    Button btnLogin,btnRegister;
    List<NameValuePair> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               String emailText = etEmail.getText().toString();
               String passwordText = etPassword.getText().toString();
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", emailText));
                params.add(new BasicNameValuePair("password", passwordText));
                ServerComm sr = new ServerComm();
               // JSONObject json = sr.getJSON("http://localhost:8080/register",params);
                  JSONObject json = sr.getJSON("http://192.168.56.1:8080/register",params);

                if(json != null){
                    try{
                        String jsonstr = json.getString("response");

                        Toast.makeText(getApplication(), jsonstr, Toast.LENGTH_LONG).show();

                        Log.d("Hello", jsonstr);
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String emailText = etEmail.getText().toString();
                String passwordText = etPassword.getText().toString();
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", emailText));
                params.add(new BasicNameValuePair("password", passwordText));
                ServerComm sr = new ServerComm();
               // JSONObject json = sr.getJSON("http://localhost:8080/login",params);
                JSONObject json = sr.getJSON("http://192.168.56.1:8080/login",params);

                if(json != null){
                    try{
                        String jsonstr = json.getString("response");
                        String jsonLogin = json.getString("res");

                        if(jsonLogin=="true") {
                                    Intent op = new Intent(MainActivity.this, Options.class);
                                    startActivity(op);
                                }
                        Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
