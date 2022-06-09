package org.casjedcem.Farmshop.model;


        import lombok.*;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.util.Collection;

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
    /*
    private String image;

    @OneToMany(mappedBy = "category")
    private Collection<Product> products;


    public Category(String name, String thumbnails, String description, Collection<Product> products) {
        super();
        this.name = name;
        this.image = thumbnails;
        this.description = description;
        this.products = products;
    }



*/



}





