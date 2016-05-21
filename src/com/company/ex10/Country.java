package com.company.ex10;

import java.math.BigDecimal;
import java.util.List;

public interface Country {
    String getName();

    Long getPopulation();

    Double getSquare();

    State[] getStates();
}
