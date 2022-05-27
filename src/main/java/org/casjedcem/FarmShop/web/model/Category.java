package org.casjedcem.FarmShop.web.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
    @Entity
    @Table(name="category")
    @EqualsAndHashCode(of = {"id", "name"})
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Category implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        @Column(nullable = false)
        private String image;
        private String description;


        @OneToMany(mappedBy = "category")
        private Collection<Product> products;


        public Category(String name, String thumbnails, String description, Collection<Product> products) {
            super();
            this.name = name;
            this.image = thumbnails;
            this.description = description;
            this.products = products;
        }







    }





