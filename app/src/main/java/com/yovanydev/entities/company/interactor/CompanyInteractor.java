package com.yovanydev.entities.company.interactor;

import android.content.Context;

import com.yovanydev.data.entities.company.memory.CompanyRepository;
import com.yovanydev.entities.company.model.Company;
import com.yovanydev.entities.company.presenter.ICompanyPresenter;
import com.yovanydev.entities.general.view.IView;

public class CompanyInteractor implements ICompanyInteractor {

    private ICompanyPresenter presenter;
    private CompanyRepository repository;
    private IView view;
    private Context context;

    public CompanyInteractor(ICompanyPresenter presenter, IView view, Context context) {
        this.presenter = presenter;
        this.view = view;
        this.context = context;

        this.repository = CompanyRepository.getRepository(context);
    }

    @Override
    public void getCompany() {
        Company company = repository.getCompany();
        if (company != null) presenter.showCompany(company);
        else {
            company = new Company(
                    "FerreOspina", "Barrio Amistad - Ospina/Nariño",
                    "3168460999", "Miguel Jesús Orbes Romo", "miguelorbes@hotmail.com"
            );
            repository.addCompany(company);
            presenter.showCompany(company);
            //presenter.showNoResults(this.view);
        }
    }

    @Override
    public void saveCompany(Company company) {
        Company current_company = repository.getCompany();
        if (current_company == null) repository.addCompany(company);
        else repository.updateCompany(company);
    }
}
