package kn.studio.order.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CharacteristicCategory extends Category{

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private CharacteristicCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Set<CharacteristicCategory> childCategories;

    public CharacteristicCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CharacteristicCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<CharacteristicCategory> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<CharacteristicCategory> childCategories) {
        this.childCategories = childCategories;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder extends Category.Builder<CharacteristicCategory, Builder> {
        @Override
        protected CharacteristicCategory createCategory() {
            return new CharacteristicCategory();
        }

        public Builder parentCategory(CharacteristicCategory parentCategory) {
            category.setParentCategory(parentCategory);
            return this;
        }

        public Builder childCategories(Set<CharacteristicCategory> childCategories) {
            category.setChildCategories(childCategories);
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}
