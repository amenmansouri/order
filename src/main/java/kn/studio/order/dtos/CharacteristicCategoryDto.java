package kn.studio.order.dtos;

import kn.studio.order.entities.ProductCategory;

import java.util.Set;

public class CharacteristicCategoryDto {
    private Long id;

    private String name;
    private String shortDescription;
    private String description;
    private CharacteristicCategoryDto parentCategory;

    private Set<CharacteristicCategoryDto> childCategories;
    private int depth;

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

    public CharacteristicCategoryDto getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CharacteristicCategoryDto parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<CharacteristicCategoryDto> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<CharacteristicCategoryDto> childCategories) {
        this.childCategories = childCategories;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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

    public void setDescription(String description){
        this.description= description;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private final CharacteristicCategoryDto categoryDto;

        public Builder() {
            this.categoryDto = new CharacteristicCategoryDto();
        }

        public Builder id(Long id) {
            categoryDto.setId(id);
            return this;
        }

        public Builder name(String name) {
            categoryDto.setName(name);
            return this;
        }

        public Builder parentCategory(CharacteristicCategoryDto parentCategory) {
            categoryDto.setParentCategory(parentCategory);
            return this;
        }

        public Builder childCategories(Set<CharacteristicCategoryDto> childCategories) {
            categoryDto.setChildCategories(childCategories);
            return this;
        }

        public Builder depth(int depth) {
            categoryDto.setDepth(depth);
            return this;
        }

        public Builder shortDescription(String shortDescription) {
            categoryDto.setShortDescription(shortDescription);
            return this;
        }

        public Builder description(String description) {
            categoryDto.setDescription(description);
            return this;
        }

        public CharacteristicCategoryDto build() {
            return categoryDto;
        }
    }
}
