package kn.studio.order.entities.orders;

import jakarta.persistence.*;
import kn.studio.order.entities.Characteristic;
import kn.studio.order.entities.orders.OrderLine;

@Entity
public class CharacteristicByOrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderLine_id")
    private OrderLine orderLine;

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
