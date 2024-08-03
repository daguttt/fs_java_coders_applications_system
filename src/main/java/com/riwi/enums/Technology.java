package com.riwi.enums;

import java.util.Arrays;

public enum Technology {
    NEXT_JS,
    NEST_JS,
    JAVA,
    DOTNET;

    public static String listTechnologies() {
        StringBuilder listedTechnologies = new StringBuilder();
        var technologyArray = Technology.values();

        for (int i = 0; i < technologyArray.length; i++) {
            listedTechnologies.append(String.format("%d. %s%n", i + 1, technologyArray[i].name()));
        }

        return listedTechnologies.toString();
    }
}
