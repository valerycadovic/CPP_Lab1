package Model;

public abstract class Employee {
    protected String name;
    protected double cash;

    public abstract String getName();

    public double getCash(){
        return cash;
    }
}
