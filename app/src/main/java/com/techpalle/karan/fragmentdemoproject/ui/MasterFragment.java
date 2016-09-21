package com.techpalle.karan.fragmentdemoproject.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.techpalle.karan.fragmentdemoproject.R;
import com.techpalle.karan.fragmentdemoproject.ui.DetailActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {


    public MasterFragment() {
        // Required empty public constructor
    }

    ListView listView;
    String[] websiteTabNames = {"Home", "Placements", "Training", "Contact Us"};
    ArrayAdapter<String> arrayAdapter;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_master, null);

        listView = (ListView) v.findViewById(R.id.list_view_master);

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, websiteTabNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("TabName", websiteTabNames[position]);
                startActivity(intent);
            }
        });

        return v;
    }

}
