package com.company.ex10.impl;


import com.sun.corba.se.spi.orbutil.fsm.StateImpl;

public class State implements com.company.ex10.State {

    private long population;
    private Double square;
    private String name;

    public State(long population, Double square, String name) {
        this.population = population;
        this.name = name;
        this.square = square;
    }

    /**
     * @param state - штат для копирования
     * @param name  -
     * @return копию переданного параметра{@link StateImpl}state
     */
    public StateImpl copyState(State state, String name) {
        return null;
    }

    /**
     * Возвращает значение населения текущего штата.
     *
     * @return населения текущего штата.
     */
    @Override
    public Long getPopulation() {
        return population;
    }

    @Override
    public Double getSquare() {
        return square;
    }

    @Override
    public String getName() {
        return name;
    }
}
