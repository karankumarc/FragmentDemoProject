package com.techpalle.karan.fragmentdemoproject.ui.login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techpalle.karan.fragmentdemoproject.R;

public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        FragmentManager fragmentManager = getSupportFragmentManager();
        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.login_container, loginFragment).commit();
    }

    public void registerButtonClicked(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        RegisterFragment registerFragment = new RegisterFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.login_container, registerFragment);
        fragmentTransaction.addToBackStack(null).commit();

    }

    public void loginButtonClicked(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        RegisterFragment registerFragment = (RegisterFragment) fragmentManager.findFragmentById(R.id.login_container);
        if (registerFragment != null) {
            registerFragment.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public void passUserDetailsToLoginFragment(String username, String password){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt
                        (fragmentManager.getBackStackEntryCount()-1).getId(),
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        /*LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentById(R.id.login_container);
        loginFragment.setUsernameAndPassword(username, password);*/
        /*LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentById(fragmentManager.getBackStackEntryAt
                (fragmentManager.getBackStackEntryCount()-1).getId());
        loginFragment.setUsernameAndPassword(username, password);*/
    }
}
