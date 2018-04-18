package Model;

import java.util.ArrayList;

/**
 * <h1>Factory management class</h1>
 * <p>defines a set of manage methods of the factory</p>
 */
public class Factory {
    private ArrayList<Employee> employees;
    private ArrayList<IProduct> products;
    private ProductType currentType;

    /**
     * <h1>Constructor</h1>
     * @param type
     *      default type of production
     */
    public Factory(ProductType type){
        employees = new ArrayList<>();
        products = new ArrayList<>();
        currentType = type;
    }

    /**
     * @return
     *      list of employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     *
     * @return
     *      count of employees who are workers
     */
    public int getWorkersCount(){
        int count = 0;

        for (Employee e: employees) {
            if (e instanceof Worker)
                count++;
        }

        return count;
    }

    /**
     *
     * @return
     *      coutn of products
     */
    public int getProductsCount(){
        return products.size();
    }

    /**
     * <h1>Release new product protocol</h1>
     * <p>
     *     Method creates abstract product during established product type
     * </p>
     * @return
     *      abstract product
     * @throws Exception
     *      NoWorkersException
     *      WorkersNotReadyToWorkException
     */
    public IProduct release() throws Exception {

        if(this.employees.size() == 0) throw new Exception("Employ workers!");

        for(Employee worker: employees) {
            if(worker instanceof Worker)
                if (((Worker) worker).isReady())
                    ((Worker) worker).work();
                else throw new Exception("Workers want smoke!");
        }

        IProduct result;

        switch (currentType){
            case MATCH:{
                result = new Match(5);
                break;
            }
            case VEHICLE:{
                result = new Vehicle();
                break;
            }
            case PAN:{
                result = new Pan();
                break;
            }
            default: result = null;
        }

        products.add(result);
        return result;
    }

    /**
     * <h3>employs one worker</h3>
     */
    public void employ(){
        employees.add(new Worker());
    }

    /**
     * <h3>sets a type of production</h3>
     * @param type
     *      type of production
     */
    public void setType(ProductType type) {
        this.currentType = type;
    }

    /**
     * <h3>
     *     sends all products from factory to the shop.
     *     List of products is empty after this operation
     * </h3>
     * @param shop
     *      destination shop
     */
    public void sendProductsToShop(Shop shop){
        shop.addProducts(this.products);
        products.clear();
    }
}
