package org.casjedcem.Farmshop.model;


        import lombok.*;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.util.Collection;
        import java.util.List;

@Data
@Entity
@Table(name="categories")
/*@EqualsAndHashCode(of = {"id", "name"})*/
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;




}





