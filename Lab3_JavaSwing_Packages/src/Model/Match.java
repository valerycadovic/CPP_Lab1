package Model;
/**
 * <h1>Match</h1>
 * <p>
 *     an instrument for getting fire
 * </p>
 */
public class Match implements IProduct{
    private boolean canBurn = true;
    private double length;

    /**
     *
     * @param length
     *          length of an item
     */
    public Match(double length){
        this.length = length;
    }

    public String getName(){
        return "Match";
    }

    /**
     *
     * @return
     *      true - fire
     *      false - defect
     */
    public boolean getFire(){
        return canBurn;
    }

    public double getLength(){
        return length;
    }
}
