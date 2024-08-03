package com.riwi.controllers;

import com.riwi.entities.Application;
import com.riwi.models.interfaces.IApplicationsModel;

import java.util.List;
import java.util.Optional;

public class ApplicationsController {
    private final IApplicationsModel applicationsModel;

    public ApplicationsController(IApplicationsModel applicationsModel) {
        this.applicationsModel = applicationsModel;
    }

    public Application create(Application baseApplication) {
        return this.applicationsModel.create(Application);
    }

    public Optional<Application> findById(int bookingId) {
        return this.applicationsModel.findById(bookingId);
    }

    public boolean checkSeatAvailability(int flightId, String seatToCheck) {
        return this.applicationsModel.checkSeatAvailability(flightId, seatToCheck);
    }

    public List<Application> findAllByFlightId(int flightIdQuery) {
        return this.applicationsModel.findAllByFlightId(flightIdQuery);
    }

    public boolean updateApplicationSeat(int bookingId, String newSeat) {
        return this.applicationsModel.updateApplicationSeat(bookingId, newSeat);
    }

    public boolean delete(int bookingId) {
        return this.applicationsModel.delete(bookingId);
    }

}
