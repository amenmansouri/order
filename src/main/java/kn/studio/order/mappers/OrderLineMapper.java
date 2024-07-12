package kn.studio.order.mappers;

import kn.studio.order.dtos.OrderLineDto;
import kn.studio.order.entities.orders.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper implements Mapper<OrderLine, OrderLineDto> {
    @Override
    public OrderLineDto entityToDto(OrderLine orderLine) {
        return OrderLineDto.builder().build();
    }

    @Override
    public OrderLine dtoToEntity(OrderLineDto orderLineDto) {
        return OrderLine.builder().build();
    }
}
