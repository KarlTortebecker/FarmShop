package org.casjedcem.Farmshop.model;

import java.util.Set;

import javax.persistence.Entity;
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

//    @OneToMany(mappedBy = "producer")
//    private List<Product> products;


}
