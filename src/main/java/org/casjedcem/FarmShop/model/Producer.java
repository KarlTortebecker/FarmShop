package org.casjedcem.FarmShop.model;


import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


    @Data
    @Entity
    @Table(name="producers")
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Producer extends User {

        private boolean isActive;

        @OneToMany(mappedBy = "producer")
        private Set<Product> products;


    }
