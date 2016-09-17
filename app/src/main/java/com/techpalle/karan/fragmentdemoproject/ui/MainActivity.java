package com.techpalle.karan.fragmentdemoproject.ui;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.techpalle.karan.fragmentdemoproject.R;
import com.techpalle.karan.fragmentdemoproject.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Title here");
        toolbar.setSubtitle("Subtitle here");

        toolbar.setLogo(android.R.drawable.btn_star_big_on); // Logo Image
        toolbar.setNavigationIcon(android.R.drawable.ic_media_previous); // Navigation icon image

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean handled= false;
        switch (item.getItemId()){
            case R.id.action_logout:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                handled = true;
                break;
            case R.id.action_date_time_demo:
                Intent intent1 = new Intent(this, DateTimeDialogDemoActivity.class);
                startActivity(intent1);
                handled = true;
                break;
        }

        return handled;
    }
}
