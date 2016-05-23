package com.company.ex10.impl;

public class Service implements com.company.ex10.Service {
    private Country[] countries;

    public Service(Country[] countries) {
        this.countries = countries;
    }

    @Override
    public Long getCountryPopulation(String name) {
        for (Country country : countries) {
            if (country.getName().equals(name))
                return country.getPopulation();
        }
        return 0l;
    }

    @Override
    public Country getOvercrowdedCountry() {
        double max = Double.MIN_VALUE;
        double current;
        Country count = null;
        for (Country country : countries) {
            current = country.getSquare() / country.getPopulation();
            if (current > max) {
                max = current;
                count = country;
            }
        }
        return count;
    }

    @Override
    public Double getCountrySquare(String name) {
        for (Country country : countries) {
            if (country.getName().equals(name))
                return country.getSquare();
        }
        return 0d;
    }

    @Override
    public Double getTotalDensityOfPeople(String name) {
        Double totalDensity =0.0;
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                 totalDensity+=country.getPopulation() / country.getSquare();
            }
        }
        return totalDensity;
    }

    @Override
    public Double getAverageDensityOfPeopleByStates(String name) {
        Double averdest = 0.0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(name)) {
                for (int j = 0; j < countries[i].getStates().length; j++) {
                    averdest+=countries[i].getStates()[j].getPopulation()/countries[i].getStates()[j].getSquare();
                }
            }
        }
        return averdest;
    }

    @Override
    public String getOvercrowdedState(String name) {
        Double density = Double.MIN_VALUE;
        String overcrowdedState = null;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(name)) {
                for (int j = 0; j < countries[i].getStates().length; j++) {
                    if (density < countries[i].getStates()[j].getPopulation() / countries[i].getStates()[j].getSquare()) {
                        overcrowdedState =  countries[i].getStates()[j].getName();
                    }
                }
            return overcrowdedState;
            }
        }
        return null;
    }

    @Override
    public String getBiggestState(String name) {
        Double maxSq = Double.MIN_VALUE;
        String biggestState = null;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(name)) {
                for (int j = 0; j < countries[i].getStates().length; j++) {
                    if (maxSq < countries[i].getStates()[j].getSquare()) {
                        biggestState =  countries[i].getStates()[j].getName();
                    }
                }
                return biggestState;
            }
        }
        return null;
    }
}
