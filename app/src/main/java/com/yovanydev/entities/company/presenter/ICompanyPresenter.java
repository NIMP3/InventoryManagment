package com.yovanydev.entities.company.presenter;

import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.general.presenter.IBasePresenter;
import com.yovanydev.entities.general.view.IView;

public interface ICompanyPresenter extends IBasePresenter<IView> {
    void getCompany();
    void saveCompany(Company company);
    void showCompany(Company company);
}
