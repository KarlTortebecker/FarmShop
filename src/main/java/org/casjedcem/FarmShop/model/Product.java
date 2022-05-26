package org.casjedcem.FarmShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


    @Data
    @Entity
    @Table(name="products")
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Product implements Serializable {


        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_product;

        private String name;

        private String description;

        private double currentPrice;

        private boolean promotion;

        private boolean available;


        private String thumbnails;

        private int quantity;

        @ManyToOne
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private  Category category;

        @ManyToOne(optional = false)
        private Producer producer;


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

