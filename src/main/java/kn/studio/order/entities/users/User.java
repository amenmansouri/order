package kn.studio.order.entities.users;

import jakarta.persistence.*;
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
