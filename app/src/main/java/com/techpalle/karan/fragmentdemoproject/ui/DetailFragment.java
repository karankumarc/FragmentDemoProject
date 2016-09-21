package com.techpalle.karan.fragmentdemoproject.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techpalle.karan.fragmentdemoproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }

    TextView textViewDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle= getArguments();
        String detail = bundle.getString("TabName");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, null);

        textViewDetail = (TextView) v.findViewById(R.id.text_view_detail);

        textViewDetail.setText(detail);


        return v;
    }

}
