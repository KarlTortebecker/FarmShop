package org.casjedcem.FarmShop.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name="products")
@NoArgsConstructor
@ToString
public class Product implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column(unique = true, nullable = false, name="productName")
    private String productName;


    @Column(columnDefinition = "varchar(255) default 'Not described'", updatable = true, nullable = false)
    private String description;

    @Column(name = "currentPrice")
    private double currentPrice;

    @Column(name = "promotion")
    private boolean promotion;

    @Column(name = "available")
    private boolean available;

    @NotNull
    private String URLimage;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Category category;

    @ManyToOne(optional = false)
    private Producer producer;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Coupon discounts;



    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Set<Carousel> carousel;

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Coupon getDiscount() {
        return discounts;
    }
    public void setDiscount(Coupon discount) {
        this.discounts = discount;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_product == null) ? 0 : id_product.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id_product == null) {
            if (other.id_product != null)
                return false;
        } else if (!id_product.equals(other.id_product))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        return true;
    }

}




