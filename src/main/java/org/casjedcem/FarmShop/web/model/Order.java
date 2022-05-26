package org.casjedcem.FarmShop.web.model;



import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


/**
 *  order
 *
 */

@Data
@Entity
@Table(name="ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    @NotNull
    private LocalDateTime dateTime;

    private double totalAmount;

    @OneToMany(mappedBy = "command")
    private Set<OrderItem> commandItems;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn
    private Client author;

    @OneToOne
    private Payment payment;

    private double getTotal(){

        return commandItems.stream().mapToDouble(OrderItem::getAmount).sum();

    }

    private void setTotal(){

        this.totalAmount = commandItems.stream().mapToDouble(OrderItem::getAmount).sum();

    }





}

