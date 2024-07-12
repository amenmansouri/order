package kn.studio.order.dtos;

import kn.studio.order.enums.AvailabilityStatus;

public class CharacteristicDto {
    private Long id;
    private String name;
    private Double price;
    private AvailabilityStatus availabilityStatus;
    private CharacteristicCategoryDto productCharacteristicCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public CharacteristicCategoryDto getProductCharacteristicCategory() {
        return productCharacteristicCategory;
    }

    public void setProductCharacteristicCategory(CharacteristicCategoryDto productCharacteristicCategory) {
        this.productCharacteristicCategory = productCharacteristicCategory;
    }

    public CharacteristicCategoryDto getCharacteristicCategory() {
        return productCharacteristicCategory;
    }

    public void setCharacteristicCategory(CharacteristicCategoryDto productCharacteristicCategory) {
        this.productCharacteristicCategory = productCharacteristicCategory;
    }

}
