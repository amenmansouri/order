package kn.studio.order.repositories;

import kn.studio.order.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
