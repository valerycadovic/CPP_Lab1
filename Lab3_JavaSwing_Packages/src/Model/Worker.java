package Model;

/**
 * <h1>It has a very big Javadoc</h1>
 */
public class Worker extends Employee {
    private double cash;
    private String name;
    private static int id;
    private boolean isReady;

    public Worker(){
        name = this.getClass().getName() + " " + Integer.toString(++id);
        isReady = true;
    }

    /**
     * <h3>defines how worker works</h3>
     * <p>after working worker gets not ready</p>
     */
    public void work(){
        isReady = false;
    }

    /**
     * <h3>defines how worker smokes</h3>
     * <p>after smoking worker gets ready</p>
     */
    public void smoke(){
        if(new Match(5).getFire())
            isReady = true;
    }

    /**
     *
     * @return
     * <p>worker is ready if it returns true</p>
     */
    public boolean isReady(){
        return isReady;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCash() {
        return cash;
    }

}
