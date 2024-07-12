package kn.studio.order.dtos;

public class CharacteristicByOrderLineDto {
    private Long id;
    private CharacteristicDto characteristic;
    private int quantity;
    private OrderLineDto orderLine;

    public OrderLineDto getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLineDto orderLine) {
        this.orderLine = orderLine;
    }

    public CharacteristicDto getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(CharacteristicDto characteristic) {
        this.characteristic = characteristic;
    }

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
}
