package kn.studio.order.dtos;

import java.util.Set;

public class ProductCategoryDto {
    private Long id;

    private String name;
    private String shortDescription;
    private String description;
    private ProductCategoryDto parentCategory;

    private Set<ProductCategoryDto> childCategories;
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

    public ProductCategoryDto getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ProductCategoryDto parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<ProductCategoryDto> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<ProductCategoryDto> childCategories) {
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

        private ProductCategoryDto productCategoryDto;

        private Builder() {
            productCategoryDto = new ProductCategoryDto();
        }

        public Builder id(Long id) {
            productCategoryDto.id = id;
            return this;
        }

        public Builder name(String name) {
            productCategoryDto.name = name;
            return this;
        }

        public Builder shortDescription(String shortDescription) {
            productCategoryDto.shortDescription = shortDescription;
            return this;
        }

        public Builder description(String description) {
            productCategoryDto.description = description;
            return this;
        }

        public Builder parentCategory(ProductCategoryDto parentCategory) {
            productCategoryDto.parentCategory = parentCategory;
            return this;
        }

        public Builder childCategories(Set<ProductCategoryDto> childCategories) {
            productCategoryDto.childCategories = childCategories;
            return this;
        }

        public Builder depth(int depth) {
            productCategoryDto.depth = depth;
            return this;
        }

        public ProductCategoryDto build() {
            return productCategoryDto;
        }
    }
}
