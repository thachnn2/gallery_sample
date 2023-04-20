package com.thachnn.samplegallery;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.thachnn.samplegallery.ui.navigation.Navigation;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Navigation fragmentController = Navigation.init(getSupportFragmentManager(), R.id.fragment_container);
        fragmentController.openMediaFragment();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}