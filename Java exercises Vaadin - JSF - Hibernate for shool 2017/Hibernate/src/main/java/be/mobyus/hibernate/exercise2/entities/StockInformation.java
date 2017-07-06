package be.mobyus.hibernate.exercise2.entities;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by java on 08.03.17.
 */

@Entity
public class StockInformation {

    @Id
    private long id;
    @Column(name = "inStockSince")
    private Date inStockSince;
    @Column(name = "numberOfStock")
    private int numberOfStock;
    @OneToOne(cascade = CascadeType.ALL, optional = false, mappedBy = "stockInformation")
    @MapsId
    private Product product;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getInStockSince() {
        return inStockSince;
    }

    public void setInStockSince(Date inStockSince) {
        this.inStockSince = inStockSince;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        //product.setStockInformation(this);
    }
}