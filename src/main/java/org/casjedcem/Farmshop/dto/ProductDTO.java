package org.casjedcem.Farmshop.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double currentPrice;
    private String imageName;
    private int quantity;
    private int categoryId;
    private int producerUserId;
   // private int couponId;


}
