package org.casjedcem.FarmShop.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client extends User {

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "author")
    private Set<Order> history;


}