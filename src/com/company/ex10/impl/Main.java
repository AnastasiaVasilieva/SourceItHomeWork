package com.company.ex10.impl;

public class Main {
    public static void main(String[] args) {

        State[] statesForUkraine = {
                new State(18754, 9548d, "Kh"),
                new State(26431, 10541d, "lviv")
        };

        State[] statesForBelarusia = {
                new State(77225, 46418d, "Minsk"),
                new State(6124, 24689d, "Polotsk")
        };

        Country[] countries = {
                new Country("Ukraine", statesForUkraine),
                new Country("Belarusia", statesForBelarusia)
        };

        Service serv = new Service(countries);

        System.out.println(serv.getCountryPopulation("Ukraine"));
        System.out.println(serv.getCountryPopulation("Belarusia"));
        System.out.println(serv.getOvercrowdedCountry().getName());
        System.out.println(serv.getCountrySquare("Belarusia"));
        System.out.println(serv.getCountrySquare("Ukraine"));
        System.out.println(serv.getTotalDensityOfPeople("Ukraine"));
        System.out.println(serv.getTotalDensityOfPeople("Belarusia"));
        System.out.println(serv.getAverageDensityOfPeopleByStates("Ukraine"));
        System.out.println(serv.getAverageDensityOfPeopleByStates("Belarusia"));
        System.out.println(serv.getOvercrowdedState("Belarusia"));
        System.out.println(serv.getOvercrowdedState("Ukraine"));
        System.out.println(serv.getBiggestState("Ukraine"));





    }
}