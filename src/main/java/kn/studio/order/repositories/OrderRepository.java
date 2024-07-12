package kn.studio.order.repositories;

import kn.studio.order.entities.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
