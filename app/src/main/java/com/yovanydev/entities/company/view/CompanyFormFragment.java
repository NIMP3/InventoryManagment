package com.yovanydev.entities.company.view;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.yovanydev.R;
import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.company.presenter.CompanyPresenter;
import com.yovanydev.entities.company.presenter.ICompanyPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyFormFragment extends Fragment implements ICompanyView, View.OnClickListener {

    private ICompanyPresenter presenter;

    private TextInputLayout tilName, tilOwner, tilAddress, tilPhone, tilEmail;
    private EditText etName, etOwner, etAddress, etPhone, etEmail;
    private Button btnAction;

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

        tilName = view.findViewById(R.id.tilCompanyName);
        tilOwner = view.findViewById(R.id.tilCompanyOwner);
        tilAddress = view.findViewById(R.id.tilCompanyAddress);
        tilPhone = view.findViewById(R.id.tilCompanyPhone);
        tilEmail = view.findViewById(R.id.tilCompanyEmail);

        etName = view.findViewById(R.id.etCompanyName);
        etOwner = view.findViewById(R.id.etCompanyOwner);
        etAddress = view.findViewById(R.id.etCompanyAddress);
        etPhone = view.findViewById(R.id.etCompanyPhone);
        etEmail = view.findViewById(R.id.etCompanyEmail);

        btnAction = view.findViewById(R.id.btnAction);
        btnAction.setOnClickListener(this);

        if (presenter == null) {
            presenter = new CompanyPresenter(getContext(), this);
            presenter.getCompany();
        }

        return view;
    }

    @Override
    public void showCompany(Company company) {
        if (company != null) {
            btnAction.setText(getString(R.string.text_button_update_company));

            etName.setText(company.getName());
            etOwner.setText(company.getOwner());
            etAddress.setText(company.getAddress());
            etPhone.setText(company.getPhone());
            etEmail.setText(company.getEmail());
        }

    }

    @Override
    public void saveCompany() {
        Company company = new Company(
                etName.getText().toString(),
                etAddress.getText().toString(),
                etPhone.getText().toString(),
                etOwner.getText().toString(),
                etEmail.getText().toString()
        );

        presenter.saveCompany(company);
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

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAction) saveCompany();
    }
}
