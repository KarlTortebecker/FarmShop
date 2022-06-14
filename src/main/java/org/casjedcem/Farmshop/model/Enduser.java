package org.casjedcem.Farmshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "endusers")
public class Enduser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;


    private String password;

    public Enduser(Enduser enduser) {
        this.firstName =enduser.getFirstName();
        this.lastName = enduser.getLastName();
        this.email = enduser.getEmail();
        this.password = enduser.getPassword();
        this.roles = enduser.getRoles();
    }

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "enduser_role",
            joinColumns = {@JoinColumn(name = "ENDUSER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;
}
