package kn.studio.order.services.impls;

import kn.studio.order.dtos.ProductCategoryDto;
import kn.studio.order.mappers.ProductCategoryMapper;
import kn.studio.order.repositories.ProductCategoryRepository;
import kn.studio.order.services.ProductCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryMapper productCategoryMapper, ProductCategoryRepository productCategoryRepository) {
        this.productCategoryMapper = productCategoryMapper;
        this.productCategoryRepository = productCategoryRepository;
    }
@Transactional
    @Override
    public ProductCategoryDto saveOrUpdate(ProductCategoryDto dto) {
        return productCategoryMapper.entityToDto(productCategoryRepository.save(productCategoryMapper.dtoToEntity(dto)));
    }

    @Override
    public Optional<ProductCategoryDto> findById(long id) {
        return productCategoryRepository.findById(id).map(productCategoryMapper::entityToDto);
    }

    @Override
    public Page<ProductCategoryDto> findAll(Pageable pageable) {
        return productCategoryRepository.findAll(pageable).map(productCategoryMapper::entityToDto);
    }

    @Override
    public void deleteById(long id) {
        productCategoryRepository.findById(id);
    }
}
