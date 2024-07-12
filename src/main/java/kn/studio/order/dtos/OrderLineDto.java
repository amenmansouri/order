package kn.studio.order.dtos;

import java.util.ArrayList;
import java.util.List;


public class OrderLineDto {
    private Long id;
    private List<CharacteristicByOrderLineDto> characteristics = new ArrayList<>();
    private int quantity;
    private OrderDto order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CharacteristicByOrderLineDto> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicByOrderLineDto> characteristics) {
        this.characteristics = characteristics;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private OrderLineDto orderLine;

        private Builder() {
            this.orderLine= new OrderLineDto();
        }

        public Builder id(Long id) {
            orderLine.id=id;
            return this;
        }

        public Builder characteristics(List<CharacteristicByOrderLineDto> characteristics) {
            orderLine.characteristics = characteristics;
            return this;
        }

        public Builder quantity(int quantity) {
            orderLine.quantity = quantity;
            return this;
        }

        public Builder order(OrderDto order) {
            orderLine.order = order;
            return this;
        }

        public OrderLineDto build() {
            return orderLine;
        }
    }

}

