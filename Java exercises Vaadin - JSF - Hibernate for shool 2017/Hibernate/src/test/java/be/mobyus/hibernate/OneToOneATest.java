package be.mobyus.hibernate;

import be.mobyus.hibernate.exercise2.entities.Product;
import be.mobyus.hibernate.exercise2.entities.StockInformation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
//import org.springframework.util.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Date;

/**
 * Created by java on 08.03.17.
 */
@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("hibernate")
public class OneToOneATest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private SessionFactory sessionFactory;
    public void test(){
        final long productId = 5555;
        final String productName = "EenProduct";
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        StockInformation stockInformation = new StockInformation();
        Date date = new Date();
        stockInformation.setInStockSince(date);
        stockInformation.setNumberOfStock(10);
        stockInformation.setProduct(product);
        product.setStockInformation(stockInformation);
        sessionFactory.getCurrentSession().save(product);

        product = (Product) sessionFactory.getCurrentSession().createQuery("from Product").getSingleResult();
        Assert.assertNotNull(product);
        Assert.assertEquals(product.getProductId(), productId);
        Assert.assertEquals(product.getProductName(), productName);
        Assert.assertNotNull(product.getStockInformation());
        Assert.assertEquals(product.getStockInformation().getInStockSince(), date);
        Assert.assertEquals(product.getStockInformation().getNumberOfStock(), 10);
    }

}
