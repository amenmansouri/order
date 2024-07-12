package kn.studio.order.entities.users;

import jakarta.persistence.*;
import kn.studio.order.entities.Address;
import kn.studio.order.entities.PhoneNumberByUser;
import kn.studio.order.entities.Role;

import java.util.Set;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PhoneNumberByUser> phoneNumberByUsers;
    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<PhoneNumberByUser> getPhoneNumberByUsers() {
        return phoneNumberByUsers;
    }

    public void setPhoneNumberByUsers(Set<PhoneNumberByUser> phoneNumberByUsers) {
        this.phoneNumberByUsers = phoneNumberByUsers;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
