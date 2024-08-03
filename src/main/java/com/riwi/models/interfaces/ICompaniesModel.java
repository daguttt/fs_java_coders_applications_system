package com.riwi.models.interfaces;

import com.riwi.entities.Company;

import java.util.List;
import java.util.Optional;

public interface ICompaniesModel {

    Optional<Company> create(Company baseCoder);

    Optional<Company> findById(int coderIdToFind);

    List<Company> findAllByName(String nameQuery);

    boolean update(int passengerId, Company passengerToUpdate);

    boolean delete(int passengerIdToDelete);
}
