package com.company.ex10;

public interface Service {
    Long getCountryPopulation(String name);

    Country getOvercrowdedCountry();

    Double getCountrySquare(String name);

    Double getTotalDensityOfPeople(String name);

    Double getAverageDensityOfPeopleByStates(String name);

    Object getOvercrowdedState(String name);

    String getBiggestState(String name);
}