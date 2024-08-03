package com.riwi.models.interfaces;

import com.riwi.entities.Coder;

import java.util.List;
import java.util.Optional;

public interface ICodersModel {

    Optional<Coder> create(Coder baseCoder);

    Optional<Coder> findById(int coderIdToFind);

    List<Coder> findAllByName(String nameQuery);

    boolean update(int passengerId, Coder passengerToUpdate);

    boolean delete(int passengerIdToDelete);
}
