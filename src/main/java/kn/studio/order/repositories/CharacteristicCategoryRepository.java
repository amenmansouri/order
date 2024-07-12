package kn.studio.order.repositories;

import kn.studio.order.entities.CharacteristicCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicCategoryRepository extends JpaRepository<CharacteristicCategory,Long> {
}
