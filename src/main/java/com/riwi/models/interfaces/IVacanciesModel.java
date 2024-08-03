package com.riwi.models.interfaces;

import com.riwi.entities.Vacancy;

import java.util.Optional;

public interface IVacanciesModel {

    Vacancy create(Vacancy basePlane);

    Optional<Vacancy> findById(int planeIdToFind);

    boolean delete(int planeIdToDelete);

}
