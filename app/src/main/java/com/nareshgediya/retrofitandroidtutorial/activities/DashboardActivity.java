package com.nareshgediya.retrofitandroidtutorial.activities;


import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.fragments.HomeFragment;
import com.nareshgediya.retrofitandroidtutorial.fragments.PendingOrderFragment;
import com.nareshgediya.retrofitandroidtutorial.fragments.SettingsFragment;
import com.nareshgediya.retrofitandroidtutorial.fragments.CartFragment;

import com.nareshgediya.retrofitandroidtutorial.storage.SharedPrefManager;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        if (SharedPrefManager.getInstance(this).isUserLoggedIn()) {

            BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
            navigationView.setOnNavigationItemSelectedListener(this);


            displayFragment(new HomeFragment());
        }
    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isUserLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.menu_home:
                if (!item.isChecked()) {
                    fragment = new HomeFragment();
                }
                item.setChecked(true);
                break;
            case R.id.menu_cart:
                if (!item.isChecked()) {
                    fragment = new CartFragment();
                }
                item.setChecked(true);
                break;
            case R.id.menu_pending_order:
                if (!item.isChecked()) {
                    fragment = new PendingOrderFragment();
                }
                item.setChecked(true);
                break;

            case R.id.menu_settings:
                if (!item.isChecked()) {
                    fragment = new SettingsFragment();
                }
                item.setChecked(true);
                break;
        }

        if (fragment != null) {
            displayFragment(fragment);
        }

        return false;
    }
}
