package org.casjedcem.FarmShop.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Product product;
    
    private int quantity;

    private double amount;






    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order command;


	public double getAmount() {

		
		if(product == null)return 0;
		
		this.amount = product.getCurrentPrice() * quantity;
		return amount;		
	}
	


    
    
    
}
