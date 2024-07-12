package kn.studio.order.controllers;

import kn.studio.order.dtos.ProductDto;
import kn.studio.order.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService  productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ProductDto saveOrUpdate(ProductDto dto) {
        return productService.saveOrUpdate(dto);
    }
    @GetMapping("{id}")
    public Optional<ProductDto> findById(long id) {
        return productService.findById(id);
    }
    @GetMapping
    public Page<ProductDto> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }
    @DeleteMapping("{id}")
    public void deleteById(long id) {
        productService.deleteById(id);
    }
}
