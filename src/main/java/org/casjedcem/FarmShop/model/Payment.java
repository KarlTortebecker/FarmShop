package org.casjedcem.FarmShop.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datePayment;
    private long cardNumber;
    private CardType cardType = CardType.NONE;
    
    @OneToOne(mappedBy = "payment")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    public Payment(LocalDateTime datePayment, long cardNumber, CardType cardType, Order order) {
        this.datePayment = datePayment;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.order = order;
    }

}
