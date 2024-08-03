package com.riwi.models;

import com.riwi.entities.Coder;
import com.riwi.entities.Company;
import com.riwi.models.interfaces.ICompaniesModel;
import com.riwi.persistence.Database;

import java.util.List;
import java.util.Optional;

public class CompaniesModel implements ICompaniesModel {
    private final Database database;

    public CompaniesModel(Database database) {
        this.database = database;
    }

    @Override
    public Optional<Company> create(Company baseCoder) {
        return Optional.empty();
    }

    @Override
    public Optional<Company> findById(int coderIdToFind) {
        return Optional.empty();
    }

    @Override
    public List<Company> findAllByName(String nameQuery) {
        return null;
    }

    @Override
    public boolean update(int passengerId, Company passengerToUpdate) {
        return false;
    }

    @Override
    public boolean delete(int passengerIdToDelete) {
        return false;
    }
}
