package Model;

import java.util.ArrayList;

public class Worker {
    private double cash;
    private String name;
    private static int id;
    private boolean isReady;

    public Worker(){
        name = "worker " + Integer.toString(++id);
        isReady = true;
    }

    public void work(){
        isReady = false;
    }

    public void smoke(){
        if(new Match(5).getFire())
            isReady = true;
    }

    public boolean IsReady(){
        return isReady;
    }

}
