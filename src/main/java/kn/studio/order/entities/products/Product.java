package kn.studio.order.entities.products;

import jakarta.persistence.*;
import kn.studio.order.entities.CharacteristicCategory;
import kn.studio.order.entities.ProductCategory;
import kn.studio.order.enums.AvailabilityStatus;

import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String shortDescription;
    @Lob
    private String description;
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;
    private int quantity;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    @ManyToMany
    @JoinTable(
            name = "product_characteristic_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "characteristic_category_id")
    )
    private Set<CharacteristicCategory> characteristicCategories;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
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

    public Set<CharacteristicCategory> getCharacteristicCategories() {
        return characteristicCategories;
    }

    public void setCharacteristicCategories(Set<CharacteristicCategory> characteristicCategories) {
        this.characteristicCategories = characteristicCategories;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Product product;

        private Builder() {
            product = new Product();
        }

        public Builder id(Long id) {
            product.id = id;
            return this;
        }

        public Builder name(String name) {
            product.name = name;
            return this;
        }

        public Builder shortDescription(String shortDescription) {
            product.shortDescription = shortDescription;
            return this;
        }

        public Builder description(String description) {
            product.description = description;
            return this;
        }

        public Builder availabilityStatus(AvailabilityStatus availabilityStatus) {
            product.availabilityStatus = availabilityStatus;
            return this;
        }

        public Builder quantity(int quantity) {
            product.quantity = quantity;
            return this;
        }

        public Builder productCategory(ProductCategory productCategory) {
            product.productCategory = productCategory;
            return this;
        }

        public Builder characteristicCategories(Set<CharacteristicCategory> characteristicCategories) {
            product.characteristicCategories = characteristicCategories;
            return this;
        }

        public Product build() {
            return product;
        }
    }
}
