package com.techpalle.karan.fragmentdemoproject.ui.landing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techpalle.karan.fragmentdemoproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacementsFragment extends Fragment {


    public PlacementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_placements, container, false);
    }

}
