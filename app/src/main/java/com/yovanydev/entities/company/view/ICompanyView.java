package com.yovanydev.entities.company.view;

import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.general.view.IView;

public interface ICompanyView extends IView {
    void showCompany(Company company);
    void saveCompany(Company company);
}
