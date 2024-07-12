package kn.studio.order.dtos;

import java.util.Set;

public class OrderDto {
    private Long id;
    private Set<OrderLineDto> orderLines;

    public Set<OrderLineDto> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLineDto> orderLines) {
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

        private OrderDto order;

        private Builder() {
            order = new OrderDto();
        }

        public Builder id(Long id) {
            order.id = id;
            return this;
        }

        public Builder orderLines(Set<OrderLineDto> orderLines) {
            order.orderLines= orderLines;
            return this;
        }

        public OrderDto build() {
            return order;
        }
    }
}
