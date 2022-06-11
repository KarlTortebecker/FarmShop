package org.casjedcem.Farmshop.dto;

import lombok.Data;

@Data
public class ProducerDTO {
    private int userId;
    private String userName;
    private String userPhone;
    private String userPassword;
    private String userEmail;
    private String imageName;
    private boolean isActive;
}
