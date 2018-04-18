package Model;

public class Vehicle implements IProduct {
    private String name;
    private static int id;


    public Vehicle(String name){
        this.name = name + " " + Integer.toString(++id);
    }

    public String getName(){
        return name;
    }

    /**
     * <p>
     *     Establishes a protocol how a car rides
     * </p>
     */
    public void ride(){
        // RIDE
    }
}
