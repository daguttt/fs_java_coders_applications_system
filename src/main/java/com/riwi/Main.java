package com.riwi;

import com.riwi.controllers.ApplicationsController;
import com.riwi.controllers.CodersController;
import com.riwi.controllers.CompaniesController;
import com.riwi.controllers.VacanciesController;
import com.riwi.entities.Coder;
import com.riwi.enums.Technology;
import com.riwi.models.ApplicationsModel;
import com.riwi.models.CodersModel;
import com.riwi.models.CompaniesModel;
import com.riwi.models.VacanciesModel;
import com.riwi.models.interfaces.IApplicationsModel;
import com.riwi.models.interfaces.ICodersModel;
import com.riwi.models.interfaces.ICompaniesModel;
import com.riwi.models.interfaces.IVacanciesModel;
import com.riwi.persistence.Database;
import com.riwi.utils.Prompts;

import javax.swing.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("***********************************************************");
        System.out.println("Coders applications system");
        System.out.println("***********************************************************");

        String host = args[0];
        String port = args[1];
        String dbName = args[2];
        String dbUser = args[3];
        String dbPassword = args[4];

        // -****************************
        var database = new Database(host, port, dbName, dbUser, dbPassword);

        // Models
        ICodersModel codersModel = new CodersModel(database);
        ICompaniesModel companiesModel = new CompaniesModel(database);
        IVacanciesModel vacanciesModel = new VacanciesModel(database);
        IApplicationsModel applicationsModel = new ApplicationsModel(database);

        // Controllers
        var codersController = new CodersController(codersModel);
        var companiesController = new CompaniesController(companiesModel);
        var vacanciesController = new VacanciesController(vacanciesModel);
        var applicationsController = new ApplicationsController(applicationsModel);
        // -****************************

        System.out.println(Technology.listTechnologies());

        boolean isMenuOpened = true;
        while (isMenuOpened) {
            var menuOptionsMessage = """
                    ********************* Menu *********************
                    0. Salir.
                    1. Crear coder.
                    2. Crear vacante.
                    3. Crear aplicación.
                    4. Buscar coders por clan.
                    4. Buscar coders por cohorte.
                    4. Buscar coders por tecnologia.
                    5. Buscar vacantes por titulo.
                    6. Buscar vacantes por tecnologia.
                    9. Actualizar vacante.
                    11. Eliminar un vacante.
                    12. Eliminar un coder.
                    14. Eliminar una aplicacion.

                    Ingresa la opción que deseas hacer:
                    """;
            var option = JOptionPane.showInputDialog(menuOptionsMessage);
            if (option == null) return;

            switch (option) {
                case "0" -> isMenuOpened = false;
                // Create coder
                case "1" -> {
                    String basePrompt = "Creando un coder......";

                    String dniPrompt = Prompts.getPromptMessage(basePrompt, "Ingresa el documento de identidad del coder:");
                    String dni = JOptionPane.showInputDialog(dniPrompt);

                    String namePrompt = Prompts.getPromptMessage(basePrompt, "Ingresa el nombre del coder:");
                    String name = JOptionPane.showInputDialog(namePrompt);

                    String lastnamesPrompt = Prompts.getPromptMessage(basePrompt, "Ingresa los apellidos del coder:");
                    String lastnames = JOptionPane.showInputDialog(lastnamesPrompt);

                    String clanPrompt = Prompts.getPromptMessage(basePrompt, "Ingresa el clan al que pertenece el coder:");
                    String clan = JOptionPane.showInputDialog(clanPrompt);

                    String cohortPrompt = Prompts.getPromptMessage(basePrompt, "Ingresa la cohorte en la que se encuentra el coder:");
                    String cohort = JOptionPane.showInputDialog(cohortPrompt);

                    String profileBasePrompt = String.format("""
                                    Ingresa el número del perfil tecnologico del coder.
                                    %s""", Technology.listTechnologies());
                    String profilePrompt = Prompts.getPromptMessage(basePrompt, profileBasePrompt);
                    String profileNumber = JOptionPane.showInputDialog(profilePrompt);

                    Technology profile;
                    try {
                        profile = switch (profileNumber) {
                            case "1" -> Technology.NEXT_JS;
                            case "2" -> Technology.NEST_JS;
                            case "3" -> Technology.JAVA;
                            case "4" -> Technology.DOTNET;
                            default -> throw new Exception("Inválid tech profile number");
                        };
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Número inválido.");
                        break;
                    }

                    var baseCoder = new Coder(dni, name, lastnames, clan, cohort, profile);
                    var createdCoder = codersController.create(baseCoder);



                    var outputMessage = String.format("Coder creado satisfactoriamente!%n%s", createdCoder);
                    JOptionPane.showMessageDialog(null, outputMessage);
                }
                // Create vacancy
                case "2" -> {
                }
                // Create application
                case "3" -> {
                }
                // Create booking
                case "4" -> {
                }
                // Search flights by destination
                case "5" -> {
                }
                // Search passenger by name
                case "6" -> {

                }
                // Show all bookings by flight
                case "7" -> {

                }
                // Update flight departure date
                case "8" -> {
                }
                // Update passenger
                case "9" -> {

                }
                // Update booking's seat
                case "10" -> {

                }
                // Delete plane
                case "11" -> {

                }
                // Delete flight
                case "12" -> {

                }
                // Delete passenger
                case "13" -> {
                }
                // Delete booking
                case "14" -> {

                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Inténtalo de nuevo.");
            }
        }

    }
}