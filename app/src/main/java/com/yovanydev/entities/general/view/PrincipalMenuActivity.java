package com.yovanydev.entities.general.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.yovanydev.R;
import com.yovanydev.entities.company.view.CompanyFormFragment;
import com.yovanydev.entities.general.view.HomeFragment;
import com.yovanydev.utilities.FragmentUtility;
import com.yovanydev.utilities.ToolbarUtility;

public class PrincipalMenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ToolbarUtility.showToolbar(getString(R.string.title_app_name), getString(R.string.subtitle_principal_menu), false, this);

        setToolbar();

        if (navigationView != null) setupDrawerContent(navigationView);
        FragmentUtility.launchFragment(getSupportFragmentManager(), new HomeFragment(), R.id.mainContainer);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //Poner Icono del drawer toggle
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                FragmentManager manager = getSupportFragmentManager();

                switch (item.getItemId()) {
                    case R.id.navHome:
                        FragmentUtility.replaceFragment(manager, new HomeFragment(), R.id.mainContainer);
                        break;
                    case R.id.navCompany:
                        FragmentUtility.replaceFragment(manager, new CompanyFormFragment(), R.id.mainContainer);
                        break;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }
}
