package kn.studio.order.configs;

import jakarta.annotation.PostConstruct;
import kn.studio.order.dtos.CharacteristicCategoryDto;
import kn.studio.order.dtos.ProductCategoryDto;
import kn.studio.order.dtos.ProductDto;
import kn.studio.order.enums.AvailabilityStatus;
import kn.studio.order.services.CharacteristicCategoryService;
import kn.studio.order.services.ProductCategoryService;
import kn.studio.order.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class Initializer {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final CharacteristicCategoryService characteristicCategoryService;

    public Initializer(ProductService productService, ProductCategoryService productCategoryService, CharacteristicCategoryService characteristicCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.characteristicCategoryService = characteristicCategoryService;
    }

    @PostConstruct
    public void init(){
        List<ProductCategoryDto> productCategories = List.of(
                ProductCategoryDto.builder()
                        .name("PRODUCT_CATEGORY_1")
                        .description("product category description")
                        .shortDescription("product short description")
                        .depth(0)
                        .parentCategory(null)
                        .childCategories(
                                Set.of(
                                        ProductCategoryDto.builder()
                                                .name("SUB_PRODUCT_CATEGORY_1")
                                                .description("product category description")
                                                .shortDescription("product short description")
                                                .depth(1)
                                                .parentCategory(null)
                                                .childCategories(null)
                                                .build(),
                                        ProductCategoryDto.builder()
                                                .name("SUB_PRODUCT_CATEGORY_2")
                                                .description("product category description")
                                                .shortDescription("product short description")
                                                .depth(1)
                                                .parentCategory(null)
                                                .childCategories(null)
                                                .build()
                                )
                        )
                        .build(),
                ProductCategoryDto.builder()
                        .name("PRODUCT_CATEGORY_2")
                        .description("product category description")
                        .shortDescription("product short description")
                        .depth(0)
                        .parentCategory(null)
                        .childCategories(null)
                        .build()
        ).stream().map(productCategoryService::saveOrUpdate).toList();
        List<CharacteristicCategoryDto> CharacteristicCategories = List.of(
                CharacteristicCategoryDto.builder()
                        .name("CHARACTERISTIC_CATEGORY_1")
                        .description("Characteristic category description")
                        .shortDescription("Characteristic short description")
                        .depth(0)
                        .parentCategory(null)
                        .childCategories(null)
                        .build(),
                CharacteristicCategoryDto.builder()
                        .name("CHARACTERISTIC_CATEGORY_2")
                        .description("Characteristic category description")
                        .shortDescription("Characteristic short description")
                        .depth(0)
                        .parentCategory(null)
                        .childCategories(null)
                        .build()
        ).stream().map(characteristicCategoryService::saveOrUpdate).toList();
        System.out.println(productCategories);
        List.of(
                ProductDto.builder()
                        .name("PRODUCT_1")
                        .description("product description")
                        .shortDescription("product short description")
                        .availabilityStatus(AvailabilityStatus.AVAILABLE)
                        .quantity(10)
                        .productCategory(productCategories.get(0))
                        .build(),
                ProductDto.builder()
                        .name("PRODUCT_2")
                        .description("product description")
                        .shortDescription("product short description")
                        .availabilityStatus(AvailabilityStatus.AVAILABLE)
                        .quantity(10)
                        .productCategory(productCategories.get(1))
                        .build()
        ).stream().forEach(productService::saveOrUpdate);

    }
}
