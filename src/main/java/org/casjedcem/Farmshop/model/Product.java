package org.casjedcem.Farmshop.model;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="products")
@NoArgsConstructor
@ToString
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @Column(columnDefinition = "varchar(255) default 'Not described'", updatable = true, nullable = false)
    private String description;

    @Column(name = "currentPrice")
    private double currentPrice;

    @Column(name = "in_promotion")
    private boolean inPromotion;

    @Column(name = "is_available")
    private boolean isAvailable;

    @NotNull
    @Column(name="image_name")
    private String imageName;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="category_id")
    private  Category category;
//
//    @ManyToOne(optional = false)
//    private Producer producer;


//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Coupon discounts;


/*
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }*/

}




