package com.springrest.app.model;

public  class Money implements Expression {

    protected final int amount;
    protected final String currency;
    public Money(int amount, String currency) {
        this.amount=amount;
        this.currency=currency;
    }
    public String currency(){
        return currency;
    }
    public boolean equals(Object object){
        Money money=(Money) object;
        return amount==money.amount
                && this.currency.equals(money.currency);
    }
    @Override
    public Money reduce(Bank bank,String to){
        return new Money(amount / bank.rate(this.currency,to) , to);
    }
    public static Money dollar(int amount){
        return new Dollar(amount,"USD");
    }
    public static Money franc(int amount){
        return new Franc(amount,"CFH");
    }
    @Override
    public Expression times(int multiplier){
       return  new Money(amount * multiplier , this.currency);
     }
     @Override
     public Expression plus(Expression added){
        return new Sum(this,added);
     }
}
