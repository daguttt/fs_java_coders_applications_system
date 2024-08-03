package com.riwi.controllers;

import com.riwi.entities.Vacancy;
import com.riwi.models.interfaces.IVacanciesModel;

import java.util.List;
import java.util.Optional;

public class VacanciesController {
    private final IVacanciesModel vacanciesModel;

    public VacanciesController(IVacanciesModel vacanciesModel) {
        this.vacanciesModel = vacanciesModel;
    }

    public Vacancy create(Vacancy baseFlight) {
        return this.vacanciesModel.create(baseFlight);
    }

    public List<Vacancy> findAllByDestination(String destination) {
        return this.vacanciesModel.findAllByDestination(destination);
    }

    public Optional<Vacancy> findById(int flightIdToFind) {
        return this.vacanciesModel.findById(flightIdToFind);
    }

    public boolean update(Vacancy flightToUpdate, int flightId) {
        return this.vacanciesModel.update(flightId, flightToUpdate);
    }

    public boolean delete(int flightId) {
        return this.vacanciesModel.delete(flightId);
    }
}
