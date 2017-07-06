package be.mobyus.hibernate.exercise2.entities;

import javax.persistence.*;


/**
 * Created by java on 08.03.17.
 */


@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "productId")
    private long productId;
    @Column(name = "productName")
    private String productName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private StockInformation stockInformation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public StockInformation getStockInformation() {
        return stockInformation;
    }

    public void setStockInformation(StockInformation stockInformation) {
        this.stockInformation = stockInformation;
        stockInformation.setProduct(this);
    }
}
