package kn.studio.order.dtos;

import kn.studio.order.enums.AvailabilityStatus;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProductDto {
    private Long id;
    private String name;
    private String shortDescription;
    private String description;
    private AvailabilityStatus availabilityStatus;
    private int quantity;
    private ProductCategoryDto productCategory;
    private Set<CharacteristicCategoryDto> characteristicCategories = new LinkedHashSet<>();

    public ProductCategoryDto getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDto productCategory) {
        this.productCategory = productCategory;
    }

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<CharacteristicCategoryDto> getCharacteristicCategories() {
        return characteristicCategories;
    }

    public void setCharacteristicCategories(Set<CharacteristicCategoryDto> characteristicCategories) {
        this.characteristicCategories = characteristicCategories;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ProductDto productDto;

        private Builder() {
            productDto = new ProductDto();
        }

        public Builder id(Long id) {
            productDto.id = id;
            return this;
        }

        public Builder name(String name) {
            productDto.name = name;
            return this;
        }

        public Builder shortDescription(String shortDescription) {
            productDto.shortDescription = shortDescription;
            return this;
        }

        public Builder description(String description) {
            productDto.description = description;
            return this;
        }

        public Builder availabilityStatus(AvailabilityStatus availabilityStatus) {
            productDto.availabilityStatus = availabilityStatus;
            return this;
        }

        public Builder quantity(int quantity) {
            productDto.quantity = quantity;
            return this;
        }

        public Builder productCategory(ProductCategoryDto productCategory) {
            productDto.productCategory = productCategory;
            return this;
        }

        public Builder characteristicCategories(Set<CharacteristicCategoryDto> characteristicCategories) {
            productDto.characteristicCategories = characteristicCategories;
            return this;
        }

        public ProductDto build() {
            return productDto;
        }
    }
}
