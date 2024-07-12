package kn.studio.order.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ProductCategory extends Category{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    private ProductCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Set<ProductCategory> childCategories;

    public ProductCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ProductCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<ProductCategory> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<ProductCategory> childCategories) {
        this.childCategories = childCategories;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder extends Category.Builder<ProductCategory, Builder> {
        @Override
        protected ProductCategory createCategory() {
            return new ProductCategory();
        }

        public Builder parentCategory(ProductCategory parentCategory) {
            category.setParentCategory(parentCategory);
            return this;
        }

        public Builder childCategories(Set<ProductCategory> childCategories) {
            category.setChildCategories(childCategories);
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}
