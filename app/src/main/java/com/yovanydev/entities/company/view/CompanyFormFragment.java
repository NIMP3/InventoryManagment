package com.yovanydev.entities.company.view;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yovanydev.R;
import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.company.presenter.CompanyPresenter;
import com.yovanydev.entities.company.presenter.ICompanyPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyFormFragment extends Fragment implements ICompanyView {

    private ICompanyPresenter presenter;

    private TextView tvCompanyInfo;

    public CompanyFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_form, container, false);

        tvCompanyInfo = view.findViewById(R.id.tvCompanyInfo);

        if (presenter == null) {
            presenter = new CompanyPresenter(getContext(), this);
            presenter.getCompany();
        }

        return view;
    }

    @Override
    public void showCompany(Company company) {
        tvCompanyInfo.setText(company.toString());
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
