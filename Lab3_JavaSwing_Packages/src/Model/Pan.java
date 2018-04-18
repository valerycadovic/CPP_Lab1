package Model;

public class Pan implements IProduct {
    private static int id;
    private String name;
    private double capacity;

    public Pan(){
        this.name = "Pan " + Integer.toString(++id);
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @return
     * <p>capacity of a pan</p>
     */
    public double getCapacity() {
        return capacity;
    }
}
