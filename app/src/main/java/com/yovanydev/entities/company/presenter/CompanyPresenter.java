package com.yovanydev.entities.company.presenter;

import android.content.Context;

import com.yovanydev.R;
import com.yovanydev.entities.company.interactor.CompanyInteractor;
import com.yovanydev.entities.company.interactor.ICompanyInteractor;
import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.company.view.ICompanyView;
import com.yovanydev.entities.general.view.IView;
import com.yovanydev.utilities.SnackBarUtility;

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
    public void saveCompany(Company company) {
        view.showProgressbar();
        interactor.saveCompany(company);
    }

    @Override
    public void showCompany(Company company) {
        view.hideProgressbar();
        ((ICompanyView) view).showCompany(company);
    }

    @Override
    public void showNoResults(IView view) {
        view.hideProgressbar();
        view.showSnackBarMessage(context.getString(R.string.no_results_company_message), SnackBarUtility.ANIMATION_INFO);
    }

    @Override
    public void showSystemError(IView view, int type) {

    }

    @Override
    public void showNoNetworkError(IView view, int type) {

    }

    @Override
    public void showSuccessfulMessage(IView view, String message, int type) {
        view.showDialogMessage(message, type);
    }
}
