package com.riwi.models.interfaces;

import com.riwi.entities.Application;

import java.util.List;
import java.util.Optional;

public interface IApplicationsModel {

    Application create(Application baseFlight);

    List<Application> findAllByDestination(String destinationQuery);

    Optional<Application> findById(int flightIdToFind);

    boolean update(int flightId, Application flightToUpdate);

    boolean delete(int flightIdToDelete);
}
