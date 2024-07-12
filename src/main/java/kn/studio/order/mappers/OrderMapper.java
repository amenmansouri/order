package kn.studio.order.mappers;

import kn.studio.order.dtos.OrderDto;
import kn.studio.order.entities.orders.Order;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderMapper implements Mapper<Order, OrderDto> {
    private final OrderLineMapper orderLineMapper;

    public OrderMapper(OrderLineMapper orderLineMapper) {
        this.orderLineMapper = orderLineMapper;
    }

    @Override
    public OrderDto entityToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .orderLines(order.getOrderLines().stream().map(orderLineMapper::entityToDto).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public Order dtoToEntity(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .orderLines(orderDto.getOrderLines().stream().map(orderLineDto -> orderLineMapper.dtoToEntity(orderLineDto)).collect(Collectors.toSet()))
                .build();
    }
}
