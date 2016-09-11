package com.techpalle.karan.fragmentdemoproject.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.techpalle.karan.fragmentdemoproject.R;
import com.techpalle.karan.fragmentdemoproject.data.MyDatabase;
import com.techpalle.karan.fragmentdemoproject.ui.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {


    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegister;

    public LoginFragment() {
        // Required empty public constructor
    }

    MyDatabase database;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        database = new MyDatabase(getActivity());

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editTextUsername = (EditText) view.findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) view.findViewById(R.id.edit_text_password);
        buttonLogin = (Button) view.findViewById(R.id.button_login);
        textViewRegister = (TextView) view.findViewById(R.id.text_view_register);

        textViewRegister.setOnClickListener(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if(database.validateUser(username, password)){
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        LoginActivity activity = (LoginActivity) getActivity();
        activity.registerButtonClicked();
    }

    public void setUsernameAndPassword(String username, String password) {
        editTextUsername.setText(username);
        editTextPassword.setText(password);
    }
}
