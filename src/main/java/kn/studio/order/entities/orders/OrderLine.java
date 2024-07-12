package kn.studio.order.entities.orders;

import jakarta.persistence.*;
import kn.studio.order.entities.Characteristic;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "orderLine", orphanRemoval = true)
    private List<CharacteristicByOrderLine> characteristics = new ArrayList<>();
    private int quantity=1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<CharacteristicByOrderLine> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicByOrderLine> characteristics) {
        this.characteristics = characteristics;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void addCharacteristic(CharacteristicByOrderLine characteristic) {
        this.characteristics.add(characteristic);
    }

    public void removeCharacteristic(Characteristic characteristic) {
        this.characteristics.remove(characteristic);
    }
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private OrderLine orderLine;

        private Builder() {
            this.orderLine= new OrderLine();
        }

        public Builder id(Long id) {
            orderLine.id=id;
            return this;
        }

        public Builder characteristics(List<CharacteristicByOrderLine> characteristics) {
            orderLine.characteristics = characteristics;
            return this;
        }

        public Builder quantity(int quantity) {
            orderLine.quantity = quantity;
            return this;
        }

        public Builder order(Order order) {
            orderLine.order = order;
            return this;
        }

        public OrderLine build() {
            return orderLine;
        }
    }

}

