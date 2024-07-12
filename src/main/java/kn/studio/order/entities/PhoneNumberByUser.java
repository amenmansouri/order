package kn.studio.order.entities;

import jakarta.persistence.*;
import kn.studio.order.entities.users.UserDetails;

@Entity
public class PhoneNumberByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "phone_number_id")
    private PhoneNumber phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
