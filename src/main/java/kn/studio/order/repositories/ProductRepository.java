package kn.studio.order.repositories;

import kn.studio.order.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
