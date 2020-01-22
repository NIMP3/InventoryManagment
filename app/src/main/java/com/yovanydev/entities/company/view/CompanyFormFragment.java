package com.yovanydev.entities.company.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yovanydev.R;
import com.yovanydev.entities.company.model.Company;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyFormFragment extends Fragment implements ICompanyView {


    public CompanyFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_form, container, false);
    }

    @Override
    public void showCompany(Company company) {

    }

    @Override
    public void saveCompany(Company company) {

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showMessage(String error, int typeOfError) {

    }

    @Override
    public void showDialogMessage(String error, int typeOfError) {

    }

    @Override
    public void showSnackBarMessage(String error, int typeOfError) {

    }
}
