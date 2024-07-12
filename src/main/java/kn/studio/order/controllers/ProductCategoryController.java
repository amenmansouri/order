package kn.studio.order.controllers;

import kn.studio.order.dtos.ProductCategoryDto;
import kn.studio.order.services.ProductCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product_categories")
public class ProductCategoryController {
    private final ProductCategoryService  productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }
    @PostMapping
    public ProductCategoryDto saveOrUpdate(ProductCategoryDto dto) {
        return productCategoryService.saveOrUpdate(dto);
    }
    @GetMapping("{id}")
    public Optional<ProductCategoryDto> findById(long id) {
        return productCategoryService.findById(id);
    }
    @GetMapping
    public Page<ProductCategoryDto> findAll(Pageable pageable) {
        return productCategoryService.findAll(pageable);
    }
    @DeleteMapping("{id}")
    public void deleteById(long id) {
        productCategoryService.deleteById(id);
    }
}
