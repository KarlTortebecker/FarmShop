package org.casjedcem.FarmShop.web.model;


import lombok.*;

import javax.persistence.*;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
        private String thumbnails;
        private String description;


        @OneToMany(mappedBy = "category")
        private Collection<Product> products;


        public Category(String name, String thumbnails, String description, Collection<Product> products) {
            super();
            this.name = name;
            this.thumbnails = thumbnails;
            this.description = description;
            this.products = products;
        }


        public String addThumbnail(String src) {

            List<String> srcs = Arrays.asList(thumbnails.split(";"));

            if(srcs.size() == 3) return thumbnails;
            srcs.add(src);

            thumbnails = StringUtils.collectionToDelimitedString(srcs, ";");

            return thumbnails;
        }

        public void removeThumbnail(int index) {

            List<String> srcs = Arrays.asList(thumbnails.split(";"));

            if( index < srcs.size() && index >= 0) {

                srcs.remove(index);

                thumbnails = StringUtils.collectionToDelimitedString(srcs, ";");

            }

        }






    }





