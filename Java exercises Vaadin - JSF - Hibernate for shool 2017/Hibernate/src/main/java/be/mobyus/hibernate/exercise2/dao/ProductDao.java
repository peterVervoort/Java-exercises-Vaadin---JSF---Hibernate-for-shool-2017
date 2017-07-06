package be.mobyus.hibernate.exercise2.dao;

import be.mobyus.hibernate.exercise2.entities.Product;

import java.util.List;

/**
 * Created by java on 08.03.17.
 */
public interface ProductDao {

    public List<Product> findAll();

    public List<Product> findByProductId(long productId);

    public List<Product> findByProductName(String productName);

    public void saveProduct(Product product);

    public void removeProduct(Product product);

}
