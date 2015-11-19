package com.iulbpns.lbpnsandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Asad 15R on 11/16/2015.
 */
public class RestaurantFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_restaurant,container,false);


        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExpanded);



        // prepare list data
        constructData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return rootView;
    }

    private void constructData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("KFC");
        listDataHeader.add("Pizza Hut");
        listDataHeader.add("Burger King");

        // Adding child data
        List<String> kfc = new ArrayList<String>();
        kfc.add("Burger");
        kfc.add("Chicken Wings");
        kfc.add("Sandwich");
        kfc.add("Fajita Roll");


        List<String> pizzahut = new ArrayList<String>();
        pizzahut.add("Chicken Tikka");
        pizzahut.add("Fajita");
        pizzahut.add("Afghani Tikka");
        pizzahut.add("Garlic Bread");


        List<String> bk = new ArrayList<String>();
        bk.add("Chicken Burger");
        bk.add("Jumbo Zinger");
        bk.add("Club Sandwich");
        bk.add("Beef Burger");


        listDataChild.put(listDataHeader.get(0), kfc); // Header, Child data
        listDataChild.put(listDataHeader.get(1), pizzahut);
        listDataChild.put(listDataHeader.get(2), bk);
    }
}
