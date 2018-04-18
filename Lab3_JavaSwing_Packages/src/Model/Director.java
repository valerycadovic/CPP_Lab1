package Model;

/**
 * <h1>Class of Local Factory Boss</h1>
 */

public class Director extends Employee{
    private Factory factory;

    public Director(Factory factory){
        this.factory = factory;
    }

    @Override
    public String getName(){
        return this.name;
    }
    /**
     * <h3>resets manageable factory production type</h3>
     *
     * @param type
     *         new type
     */
    public void changeType(ProductType type) {
        factory.setType(type);
    }
}
