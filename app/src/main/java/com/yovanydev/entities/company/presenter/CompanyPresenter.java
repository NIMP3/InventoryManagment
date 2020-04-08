package com.yovanydev.entities.company.presenter;

import android.content.Context;

import com.yovanydev.R;
import com.yovanydev.data.entities.general.ConstantsRepository;
import com.yovanydev.entities.company.interactor.CompanyInteractor;
import com.yovanydev.entities.company.interactor.ICompanyInteractor;
import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.company.view.ICompanyView;
import com.yovanydev.entities.general.view.IView;
import com.yovanydev.utilities.DialogUtility;
import com.yovanydev.utilities.SnackBarUtility;

import java.util.ArrayList;
import java.util.Arrays;

public class CompanyPresenter implements ICompanyPresenter{

    private Context context;
    private IView view;
    private ICompanyInteractor interactor;

    public CompanyPresenter(Context context, IView view) {
        this.context = context;
        this.view = view;
        this.interactor = new CompanyInteractor(this, view, context);
    }

    @Override
    public void getCompany() {
        view.showProgressbar();
        interactor.getCompany();
    }

    @Override
    public void addCompany(Company company) {
        view.showProgressbar();
        interactor.addCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        view.showProgressbar();
        interactor.updateCompany(company);
    }

    @Override
    public void showCompany(Company company) {
        view.hideProgressbar();
        ((ICompanyView) view).showCompany(company);
    }

    @Override
    public void showCompanyPostAdd(Company company) {
        ((ICompanyView) view).showCompany(company);
    }

    @Override
    public void showNoResults(IView view) {
        view.hideProgressbar();
        processTypeOfView(ConstantsRepository.CODE_SNACKBAR, DialogUtility.ANIMATION_INFO, this.context.getString(R.string.no_results_company_message));
    }

    @Override
    public void showSystemError(IView view, int type) {
        String message = this.context.getString(R.string.message_error_system);
        processTypeOfView(type, DialogUtility.ANIMATION_ERROR, message);
    }

    @Override
    public void showServerError(IView view, int type) {
        String message = this.context.getString(R.string.message_error_server);
        processTypeOfView(type, DialogUtility.ANIMATION_ERROR, message);
    }

    @Override
    public void showNoNetworkError(IView view, int type) {
        String message = this.context.getString(R.string.message_error_connection);
        processTypeOfView(type, DialogUtility.ANIMATION_ERROR, message);
    }

    @Override
    public void showSuccessfulMessage(IView view, String message, int type) {
        processTypeOfView(type, DialogUtility.ANIMATION_CHECK, message);
    }

    private void processTypeOfView(int type, int iconType, String message) {
        switch (type) {
            case ConstantsRepository.CODE_VIEW:
                view.showMessage(message, iconType);
                break;
            case ConstantsRepository.CODE_DIALOG:
                view.showDialogMessage(message, iconType);
                break;
            case ConstantsRepository.CODE_SNACKBAR:
                view.showSnackBarMessage(message, iconType);
                break;
        }
    }
}
