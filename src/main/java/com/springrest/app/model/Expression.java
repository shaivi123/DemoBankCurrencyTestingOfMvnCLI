package com.springrest.app.model;

public interface Expression {

    Money reduce(Bank bank,String to);

    Expression plus(Expression added);
    Expression times(int multiplier);

}
