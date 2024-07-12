package kn.studio.order.entities;

import jakarta.persistence.*;
import kn.studio.order.enums.AvailabilityStatus;

@Entity
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CharacteristicCategory productCharacteristicCategory;

    public CharacteristicCategory getCharacteristicCategory() {
        return productCharacteristicCategory;
    }

    public void setCharacteristicCategory(CharacteristicCategory productCharacteristicCategory) {
        this.productCharacteristicCategory = productCharacteristicCategory;
    }

}
