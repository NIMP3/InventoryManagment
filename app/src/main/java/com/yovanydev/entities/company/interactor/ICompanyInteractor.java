package com.yovanydev.entities.company.interactor;

import com.yovanydev.entities.company.model.Company;

public interface ICompanyInteractor {
    void getCompany();
    void saveCompany(Company company);
}
