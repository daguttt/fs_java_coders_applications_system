package com.riwi.models;

import com.riwi.persistence.Database;
import com.riwi.entities.Application;
import com.riwi.models.interfaces.IApplicationsModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApplicationsModel implements IApplicationsModel {
    private final Database database;
    public ApplicationsModel(Database database) {
        this.database = database;
    }

    @Override
    public Application create(Application baseFlight) {
        var connection = database.openConnection();
        var sql = """
                INSERT INTO flights (destination, departure_date, departure_time, planes_id)\s
                    VALUES (?, ?, ?, ?);
                """;

        try (var statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, baseFlight.getDestination());
            statement.setDate(2, baseFlight.getDepartureDate());
            statement.setTime(3, baseFlight.getDepartureTime());
            statement.setInt(4, baseFlight.getPlanesId());

            statement.execute();

            var resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                var givenFlightId = resultSet.getInt(1);
                baseFlight.setId(givenFlightId);
            } else throw new SQLException("Couldn't create flight");

            resultSet.close();

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        database.closeConnection();
        return baseFlight;
    }

    @Override
    public List<Application> findAllByDestination(String destinationQuery) {
        var connection = database.openConnection();
        var sql = """
                SELECT id, destination, departure_date, departure_time, planes_id\s
                FROM flights WHERE destination LIKE ?;
                """;

        var flightList = new ArrayList<Application>();

        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, destinationQuery);

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var destination = resultSet.getString("destination");
                var departureDate = resultSet.getDate("departure_date");
                var departureTime = resultSet.getTime("departure_time");
                var planesId = resultSet.getInt("planes_id");
                var flight = new Application(id, destination, departureDate, departureTime, planesId);
                flightList.add(flight);
            }
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        database.closeConnection();
        return flightList.stream().toList();
    }

    @Override
    public Optional<Application> findById(int flightIdToFind) {
        var connection = database.openConnection();
        var sql = "SELECT id, destination, departure_date, departure_time, planes_id FROM flights WHERE id = ?";

        Optional<Application> flight = Optional.empty();
        try(var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, flightIdToFind);

            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getInt("id");
                var destination = resultSet.getString("destination");
                var departureDate = resultSet.getDate("departure_date");
                var departureTime = resultSet.getTime("departure_time");
                var planesId = resultSet.getInt("planes_id");
                flight = Optional.of(new Application(id, destination, departureDate, departureTime, planesId));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        database.closeConnection();
        return flight;
    }

    @Override
    public boolean update(int flightId, Application flightToUpdate) {
        var connection = database.openConnection();
        var sql = """
                UPDATE LOW_PRIORITY flights\s
                SET
                    destination = ?,
                    departure_date = ?,
                    departure_time = ?,
                    planes_id = ?
                WHERE id = ?;
               """;

        boolean couldUpdate = false;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, flightToUpdate.getDestination());
            statement.setDate(2, flightToUpdate.getDepartureDate());
            statement.setTime(3, flightToUpdate.getDepartureTime());
            statement.setInt(4, flightToUpdate. getPlanesId());
            statement.setInt(5, flightId);

            var affectedRows = statement.executeUpdate();
            statement.close();

            if (affectedRows == 1) couldUpdate = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        database.closeConnection();
        return couldUpdate;
    }

    @Override
    public boolean delete(int flightIdToDelete) {
        var connection = database.openConnection();
        var sql = """
                DELETE FROM flights\s
                WHERE id = ?;
               """;

        boolean couldDelete = false;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, flightIdToDelete);

            var affectedRows = statement.executeUpdate();
            statement.close();

            if (affectedRows == 1) couldDelete = true;

        } catch (SQLException e) {
            System.out.printf("Error deleting flight (Error %s): %s%nflightId: %d", e.getClass(), e.getMessage(), flightIdToDelete);
            couldDelete = false;
        }

        database.closeConnection();
        return couldDelete;

    }
}
