package com.techpalle.karan.fragmentdemoproject.ui.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.techpalle.karan.fragmentdemoproject.R;
import com.techpalle.karan.fragmentdemoproject.data.MyDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener{

    MyDatabase myDatabase;

    private EditText editTextUsername, editTextPassword, editTextConfirmPassword;
    private Button buttonRegister;
    private TextView textViewLogin;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myDatabase = new MyDatabase(getActivity());

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        editTextUsername = (EditText) view.findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) view.findViewById(R.id.edit_text_password);
        editTextConfirmPassword = (EditText) view.findViewById(R.id.edit_text_confirm_password);
        buttonRegister = (Button) view.findViewById(R.id.button_register);
        textViewLogin = (TextView) view.findViewById(R.id.text_view_go_to_login);

        buttonRegister.setOnClickListener(this);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity loginActivity = (LoginActivity) getActivity();
                loginActivity.loginButtonClicked();
            }
        });

        return view;
    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt
                (fragmentManager.getBackStackEntryCount()-1).getId(),
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_register){
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            if(username.length()<5 || password.length()<5){
                Toast.makeText(getActivity(), "Username and password must be at least 5 characters long", Toast.LENGTH_SHORT).show();
            } else {
                myDatabase.createRowUsersDetails(username,password);
                LoginActivity loginActivity = (LoginActivity) getActivity();
                loginActivity.passUserDetailsToLoginFragment(username, password);
            }
        }
    }
}
