package com.riwi.controllers;

import com.riwi.entities.Coder;
import com.riwi.models.interfaces.ICodersModel;

import java.util.List;
import java.util.Optional;

public class CodersController {
    private final ICodersModel codersModel;

    public CodersController(ICodersModel codersModel) {
        this.codersModel = codersModel;
    }

    public Optional<Coder> create(Coder baseCoder) {
        return this.codersModel.create(baseCoder);
    }

    public Optional<Coder> findById(int passengerIdToFind) {
        return this.codersModel.findById(passengerIdToFind);
    }

    public List<Coder> findAllByName(String name) {
        return this.codersModel.findAllByName(name);
    }

    public boolean update(int passengerId, Coder passengerToUpdate) {
        return this.codersModel.update(passengerId, passengerToUpdate);
    }

    public boolean delete(int passengerId) {
        return this.codersModel.delete(passengerId);
    }
}
