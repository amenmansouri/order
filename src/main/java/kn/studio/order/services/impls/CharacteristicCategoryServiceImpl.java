package kn.studio.order.services.impls;

import kn.studio.order.dtos.CharacteristicCategoryDto;
import kn.studio.order.mappers.CharacteristicCategoryMapper;
import kn.studio.order.repositories.CharacteristicCategoryRepository;
import kn.studio.order.services.CharacteristicCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CharacteristicCategoryServiceImpl implements CharacteristicCategoryService {
    private final CharacteristicCategoryMapper characteristicCategoryMapper;
    private final CharacteristicCategoryRepository characteristicCategoryRepository;

    public CharacteristicCategoryServiceImpl(CharacteristicCategoryMapper characteristicCategoryMapper, CharacteristicCategoryRepository characteristicCategoryRepository) {
        this.characteristicCategoryMapper = characteristicCategoryMapper;
        this.characteristicCategoryRepository = characteristicCategoryRepository;
    }
    @Transactional
    @Override
    public CharacteristicCategoryDto saveOrUpdate(CharacteristicCategoryDto dto) {
        return characteristicCategoryMapper.entityToDto(characteristicCategoryRepository.save(characteristicCategoryMapper.dtoToEntity(dto)));
    }

    @Override
    public Optional<CharacteristicCategoryDto> findById(long id) {
        return characteristicCategoryRepository.findById(id).map(characteristicCategoryMapper::entityToDto);
    }

    @Override
    public Page<CharacteristicCategoryDto> findAll(Pageable pageable) {
        return characteristicCategoryRepository.findAll(pageable).map(characteristicCategoryMapper::entityToDto);
    }

    @Override
    public void deleteById(long id) {
        characteristicCategoryRepository.findById(id);
    }
}
