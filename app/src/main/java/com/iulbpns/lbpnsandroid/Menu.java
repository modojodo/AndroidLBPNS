package com.iulbpns.lbpnsandroid;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Asad 15R on 11/3/2015.
 */
public class Menu extends Activity{

   // String restaurants[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        String[] restaurants =  {"KFC","Pizza Hut","optp","Burger King","Hardees","Pizza Point","McDonald's","Fat Burger"};
        ListAdapter adpt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,restaurants);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adpt);
    }


}
