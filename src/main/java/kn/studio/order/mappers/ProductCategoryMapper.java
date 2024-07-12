package kn.studio.order.mappers;

import kn.studio.order.dtos.ProductCategoryDto;
import kn.studio.order.entities.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductCategoryMapper implements Mapper<ProductCategory, ProductCategoryDto> {
    @Override
    public ProductCategoryDto entityToDto(ProductCategory productCategory) {
        return Objects.nonNull(productCategory) ?
                ProductCategoryDto.builder()
                        .id(productCategory.getId())
                        .name(productCategory.getName())
                        .shortDescription(productCategory.getShortDescription())
                        .description(productCategory.getDescription())
                        .depth(productCategory.getDepth())
                        .parentCategory(this.entityToDto(productCategory.getParentCategory()))
                        .childCategories(Objects.nonNull(productCategory.getChildCategories())?productCategory.getChildCategories().stream().map(this::entityToDto).collect(Collectors.toSet()):null)
                        .build() : null;
    }

    @Override
    public ProductCategory dtoToEntity(ProductCategoryDto productCategoryDto) {
        return Objects.nonNull(productCategoryDto) ?
                ProductCategory.builder()
                        .id(productCategoryDto.getId())
                        .name(productCategoryDto.getName())
                        .shortDescription(productCategoryDto.getShortDescription())
                        .description(productCategoryDto.getDescription())
                        .depth(productCategoryDto.getDepth())
                        .parentCategory(this.dtoToEntity(productCategoryDto.getParentCategory()))
                        .childCategories(Objects.nonNull(productCategoryDto.getChildCategories())?productCategoryDto.getChildCategories().stream().map(this::dtoToEntity).collect(Collectors.toSet()):null)
                        .build() : null;
    }
}
