package kn.studio.order.mappers;

import kn.studio.order.dtos.ProductDto;
import kn.studio.order.entities.products.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Service
public class ProductMapper implements Mapper<Product, ProductDto> {
    private final ProductCategoryMapper productCategoryMapper;
    private final CharacteristicCategoryMapper characteristicCategoryMapper;

    public ProductMapper(ProductCategoryMapper productCategoryMapper, CharacteristicCategoryMapper characteristicCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
        this.characteristicCategoryMapper = characteristicCategoryMapper;
    }

    @Override
    public ProductDto entityToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .availabilityStatus(product.getAvailabilityStatus())
                .quantity(product.getQuantity())
                .productCategory(productCategoryMapper.entityToDto(product.getProductCategory()))
                .characteristicCategories(product.getCharacteristicCategories().stream().map(characteristicCategoryMapper::entityToDto).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public Product dtoToEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .shortDescription(productDto.getShortDescription())
                .description(productDto.getDescription())
                .availabilityStatus(productDto.getAvailabilityStatus())
                .quantity(productDto.getQuantity())
                .productCategory(productCategoryMapper.dtoToEntity(productDto.getProductCategory()))
                .characteristicCategories(productDto.getCharacteristicCategories().stream().map(characteristicCategoryMapper::dtoToEntity).collect(Collectors.toSet()))
                .build();
    }
}
