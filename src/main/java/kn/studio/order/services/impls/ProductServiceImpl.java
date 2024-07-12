package kn.studio.order.services.impls;

import kn.studio.order.dtos.ProductDto;
import kn.studio.order.mappers.ProductMapper;
import kn.studio.order.repositories.ProductCategoryRepository;
import kn.studio.order.repositories.ProductRepository;
import kn.studio.order.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto saveOrUpdate(ProductDto dto) {
        return productMapper.entityToDto(productRepository.save(productMapper.dtoToEntity(dto)));
    }

    @Override
    public Optional<ProductDto> findById(long id) {
        return productRepository.findById(id).map(productMapper::entityToDto);
    }

    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper::entityToDto);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
