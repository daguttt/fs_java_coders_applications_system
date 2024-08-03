package com.riwi.models;

import com.riwi.persistence.Database;
import com.riwi.entities.Vacancy;
import com.riwi.models.interfaces.IVacanciesModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class VacanciesModel implements IVacanciesModel {
    private final Database database;

    public VacanciesModel(Database database) {
        this.database = database;
    }

    @Override
    public Vacancy create(Vacancy baseVacancy) {
        var connection = database.openConnection();
        var sql = """
                INSERT INTO planes (model, capacity)\s
                    VALUES (?, ?);
                """;

        try (var statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, Vacancy.getModel());
            statement.setInt(2, Vacancy.getCapacity());

            statement.execute();

            var resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                var givenVacancyId = resultSet.getInt(1);
                Vacancy.setId(VacancyId);
            } else throw new SQLException("Couldn't create plane");

            resultSet.close();

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        database.closeConnection();
        return Vacancy;

    }

    @Override
    public Optional<Vacancy> findById(int planeIdToFind) {
        var connection = database.openConnection();
        var sql = "SELECT id, model, capacity FROM planes WHERE id = ?";

        Optional<Vacancy> plane = Optional.empty();
        try(var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, planeIdToFind);

            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getInt("id");
                var model = resultSet.getString("model");
                var capacity = resultSet.getInt("capacity");
                plane = Optional.of(new Vacancy(id, model, capacity));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        database.closeConnection();
        return plane;
    }

    @Override
    public boolean delete(int planeIdToDelete) {
        var connection = database.openConnection();
        var sql = """
                DELETE FROM planes\s
                WHERE id = ?;
               """;

        boolean couldDelete = false;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, planeIdToDelete);

            var affectedRows = statement.executeUpdate();
            statement.close();

            if (affectedRows == 1) couldDelete = true;

        } catch (SQLException e) {
            System.out.printf("Error deleting plane (Error %s): %s%nplaneId: %d", e.getClass(), e.getMessage(), planeIdToDelete);
            couldDelete = false;
        }

        database.closeConnection();
        return couldDelete;

    }
}
