package com.yovanydev.entities.company.interactor;

import android.content.Context;

import com.yovanydev.R;
import com.yovanydev.data.entities.company.memory.CompanyRepository;
import com.yovanydev.data.entities.general.ConstantsRepository;
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
        else presenter.showNoResults(this.view);
    }

    @Override
    public void addCompany(Company company) {
        repository.addCompany(company);
        company = repository.getCompany();

        if (company != null) {
            presenter.showCompanyPostAdd(company);
            presenter.showSuccessfulMessage(this.view, this.context.getString(R.string.message_successful_transaction), ConstantsRepository.CODE_DIALOG);
        }
        else presenter.showSystemError(this.view, ConstantsRepository.CODE_DIALOG);
    }

    @Override
    public void updateCompany(Company company) {
        boolean transactionFlag = repository.updateCompany(company);
        if (transactionFlag) presenter.showSuccessfulMessage(this.view, this.context.getString(R.string.message_successful_transaction), ConstantsRepository.CODE_DIALOG);
        else presenter.showSystemError(this.view, ConstantsRepository.CODE_DIALOG);
    }
}
