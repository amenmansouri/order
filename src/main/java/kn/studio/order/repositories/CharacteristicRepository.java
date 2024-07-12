package kn.studio.order.repositories;

import kn.studio.order.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic,Long> {
}
