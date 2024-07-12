package kn.studio.order.entities.orders;

import jakarta.persistence.*;
import kn.studio.order.entities.Address;

import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private Set<OrderLine> orderLines;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder {

        private Order order;

        private Builder() {
            order = new Order();
        }

        public Builder id(Long id) {
            order.id = id;
            return this;
        }

        public Builder orderLines(Set<OrderLine> orderLines) {
            order.orderLines= orderLines;
            return this;
        }

        public Order build() {
            return order;
        }
    }
}
