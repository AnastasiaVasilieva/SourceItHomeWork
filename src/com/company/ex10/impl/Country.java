package com.company.ex10.impl;

import com.company.ex10.State;

public class Country implements com.company.ex10.Country {
    private String name;
    private State[] states;
    private Long population = 0L;
    private Double square = 0d;

    public Country(String name, State[] states) {
        this.name = name;
        this.states = states;
        for (State st : states) {
            population += st.getPopulation();
            square += st.getSquare();
        }
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public Long getPopulation() {
        return population;
    }

    @Override
    public Double getSquare() {
        return square;
    }

    @Override
    public State[] getStates() {
        return states;
    }
}
