package Model;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Shop</h1>
 * <p>defines the essence of a shop</p>
 */
public class Shop {
    private LinkedList<IProduct> products;

    public Shop(){
        products = new LinkedList<>();
    }

    /**
     *
     * @return
     *      current list of products
     */
    public LinkedList<IProduct> getProducts() {
        return products;
    }

    /**
     * <h3>add range of products to the shop</h3>
     *
     * @param product
     *      product you want to add to the shop
     */
    public void addProducts(List<IProduct> product){
        products.addAll(product);
    }

}
