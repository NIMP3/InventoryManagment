package com.yovanydev.entities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yovanydev.R;
import com.yovanydev.utilities.ToolbarUtility;

public class PrincipalMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);

        ToolbarUtility.showToolbar(getString(R.string.title_app_name), getString(R.string.subtitle_principal_menu), false, this);
    }
}
