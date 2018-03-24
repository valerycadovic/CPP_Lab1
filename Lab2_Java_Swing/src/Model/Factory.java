package Model;

import java.util.ArrayList;

public class Factory {
    private ArrayList<Worker> workers;
    private ArrayList<IProduct> products;
    private ProductType type;

    public Factory(ProductType type){
        workers = new ArrayList<>();
        products = new ArrayList<>();
        this.type = type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getWorkersCount(){
        return workers.size();
    }

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

        if(workers.size() == 0) throw new Exception("Employ workers!");

        for(Worker worker: workers){
            if(worker.IsReady())
                worker.work();
            else throw new Exception("Workers want smoke!");
        }

        IProduct result;

        switch (type){
            case MATCH:{
                result = new Match(5);
                break;
            }
            case VEHICLE:{
                result = new Vehicle("vehicle");
                break;
            }
            default: result = null;
        }

        products.add(result);
        return result;
    }

    /**
     * <h1>Employs one worker</h1>
     */
    public void employ(){
        workers.add(new Worker());
    }


    public ArrayList<Worker> getWorkers(){
        return workers;
    }
}

