package com.yovanydev.entities.company.view;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Handler;
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
import com.yovanydev.utilities.DialogUtility;
import com.yovanydev.utilities.SnackBarUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyFormFragment extends Fragment implements ICompanyView, View.OnClickListener {

    private static final int INSERT_TYPE = 0;
    private static final int UPDATE_TYPE = 1;

    private ICompanyPresenter presenter;
    private Company company = new Company();
    private AlertDialog transactionDialog;
    private int transactionType = INSERT_TYPE;
    private Activity activity;

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

        activity = getActivity();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (presenter == null) {
            presenter = new CompanyPresenter(getContext(), this);
            presenter.getCompany();
        }

    }

    @Override
    public void showCompany(Company company) {
        this.company = company;

        if (company.getId() != 0){
            transactionType = UPDATE_TYPE;
            btnAction.setText(getString(R.string.text_button_update_company));
        }

        etName.setText(company.getName());
        etOwner.setText(company.getOwner());
        etAddress.setText(company.getAddress());
        etPhone.setText(company.getPhone());
        etEmail.setText(company.getEmail());

    }

    @Override
    public void saveCompany() {
        company.setName(etName.getText().toString());
        company.setAddress(etAddress.getText().toString());
        company.setPhone(etPhone.getText().toString());
        company.setOwner(etOwner.getText().toString());
        company.setEmail(etEmail.getText().toString());

        if (transactionType == INSERT_TYPE) presenter.addCompany(company);
        else presenter.updateCompany(company);
    }

    @Override
    public void showProgressbar() {
        transactionDialog = DialogUtility.createMessageDialog(
                activity,
                getString(R.string.message_process_transaction),
                DialogUtility.ANIMATION_LOAD
        );

        transactionDialog.show();
    }

    @Override
    public void hideProgressbar() {
        if (transactionDialog.isShowing()) transactionDialog.dismiss();
    }

    @Override
    public void showMessage(String error, int typeOfError) {

    }

    @Override
    public void showDialogMessage(String error, int typeOfError) {
        DialogUtility.updateDialog(transactionDialog, activity, error, typeOfError);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (transactionDialog.isShowing()) transactionDialog.dismiss();
            }
        }, 2000);
    }

    @Override
    public void showSnackBarMessage(String error, int typeOfError) {
        if (getView() != null) SnackBarUtility.createSnackBar(getView(), error, typeOfError).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAction) saveCompany();
    }
}
