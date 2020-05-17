package com.yovanydev.entities.general.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yovanydev.R;
import com.yovanydev.entities.product.view.ProductActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private Activity activity;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView ivInventory = view.findViewById(R.id.ivInventory);
        ivInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchInventory();
            }
        });

        activity = getActivity();

        return view;
    }

    private void launchInventory() {
        if (activity != null) {
            Intent intent = new Intent(activity, ProductActivity.class);
            startActivity(intent);
        }
    }



}
