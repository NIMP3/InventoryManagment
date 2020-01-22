package com.yovanydev.data.company.memory;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.yovanydev.entities.company.model.Company;

public class CompanyRepository {
    @SuppressLint("StaticFieldLeak")
    private static CompanyRepository repository;
    private ICompanyDao companyDao;

    private CompanyRepository(Context context) {
        Context appContext = context.getApplicationContext();
        CompanyDataBase dataBase = Room
                .databaseBuilder(appContext, CompanyDataBase.class, Company.TABLE_NAME)
                .allowMainThreadQueries()
                .build();

        companyDao = dataBase.getCompanyDao();
    }

    public static CompanyRepository getRepository(Context context) {
        if (repository == null) repository = new CompanyRepository(context);
        return repository;
    }

    public Company getCompany() {
        return companyDao.getCompany();
    }

    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    public void deleteCompany(Company company) {
        companyDao.deleteCompany(company);
    }

    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }

}
