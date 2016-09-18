package com.techpalle.karan.fragmentdemoproject.ui.landing;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.techpalle.karan.fragmentdemoproject.R;
import com.techpalle.karan.fragmentdemoproject.ui.DateTimeDialogDemoActivity;
import com.techpalle.karan.fragmentdemoproject.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeScreen();

        /*toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Title here");
        toolbar.setSubtitle("Subtitle here");*/


        //toolbar.setLogo(android.R.drawable.btn_star_big_on); // Logo Image
        //toolbar.setNavigationIcon(android.R.drawable.ic_media_previous); // Navigation icon image



        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        }*/


    }

    private void initializeScreen() {


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_1:
                        // Code here
                        break;
                    case R.id.item_2:
                        // Code here
                        break;
                }
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_closed);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(4);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    private class SectionPagerAdapter extends FragmentStatePagerAdapter {
        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new HomeFragment();
                case 1: return new TrainingFragment();
                case 2: return new PlacementsFragment();
                case 3: return new ContactUsFragment();
                default: return new HomeFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "Home";
                case 1: return "Training";
                case 2: return "Placement";
                case 3: return "Contact Us";
                default: return "First";
            }
        }

        @Override
        public int getCount() {
            return 4;
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
