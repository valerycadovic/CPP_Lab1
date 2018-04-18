package Model;

public class Vehicle implements IProduct {
    private static int id;
    private String name;

    public Vehicle(){
        this.name = "Vehicle " + Integer.toString(++id);
    }

    /**
     *
     * @return
     *      name of the car
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     *     Establishes a protocol how the car rides
     * </p>
     */
    public void ride(){
        // RIDE MA'FAKA
    }
}
