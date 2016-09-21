package com.techpalle.karan.fragmentdemoproject.ui.landing;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techpalle.karan.fragmentdemoproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {


    public ContactUsFragment() {
        // Required empty public constructor
    }

    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_contact_us, container, false);

        floatingActionButton = (FloatingActionButton) v.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Upload failed", Snackbar.LENGTH_LONG);
                snackbar.setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v, "Uploaded successfully", Snackbar.LENGTH_LONG).show();
                    }
                });

                View snackbarLayout = snackbar.getView();
                snackbarLayout.setBackgroundColor(Color.WHITE);

                TextView textView = (TextView) snackbarLayout.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                //snackbar.setActionTextColor(Color.BLUE);

                Button button = (Button) snackbarLayout.findViewById(android.support.design.R.id.snackbar_action);
                button.setTextColor(Color.BLACK);

                snackbar.show();
            }
        });


        return v;
    }

}
