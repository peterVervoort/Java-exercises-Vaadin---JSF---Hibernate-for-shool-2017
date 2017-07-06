package be.mobyus.hibernate.exercise2.dao;

import be.mobyus.hibernate.exercise2.entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by java on 08.03.17.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findByProductId(long productId) {
        return null;
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void removeProduct(Product product) {

    }
}
