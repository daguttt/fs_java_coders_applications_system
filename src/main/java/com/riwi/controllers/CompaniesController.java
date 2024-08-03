package com.riwi.controllers;

import com.riwi.entities.Company;
import com.riwi.models.interfaces.ICompaniesModel;

import java.util.Optional;

public class CompaniesController {
    private final ICompaniesModel companiesModel;

    public CompaniesController(ICompaniesModel companiesModel) {
        this.companiesModel = companiesModel;
    }

    public Company create(Company baseCompany) {
        return this.companiesModel.create(Company);
    }

    public Optional<Company> findById(int planeIdToFind) {
        return this.companiesModel.findById(planeIdToFind);
    }

    public boolean delete(int planeId) {
        return this.companiesModel.delete(planeId);
    }
}
