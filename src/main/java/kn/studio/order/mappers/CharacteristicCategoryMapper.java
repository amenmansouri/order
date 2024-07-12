package kn.studio.order.mappers;

import kn.studio.order.dtos.CharacteristicCategoryDto;
import kn.studio.order.entities.CharacteristicCategory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CharacteristicCategoryMapper implements Mapper<CharacteristicCategory, CharacteristicCategoryDto> {
    @Override
    public CharacteristicCategoryDto entityToDto(CharacteristicCategory characteristicCategory) {
        return Objects.nonNull(characteristicCategory) ?
                CharacteristicCategoryDto.builder()
                        .id(characteristicCategory.getId())
                        .name(characteristicCategory.getName())
                        .shortDescription(characteristicCategory.getShortDescription())
                        .description(characteristicCategory.getDescription())
                        .parentCategory(this.entityToDto(characteristicCategory.getParentCategory()))
                        .childCategories(Objects.nonNull(characteristicCategory.getChildCategories()) ?
                                characteristicCategory.getChildCategories().stream()
                                        .map(this::entityToDto)
                                        .collect(Collectors.toSet()):null)
                        .depth(characteristicCategory.getDepth())
                        .build() : null;
    }

    @Override
    public CharacteristicCategory dtoToEntity(CharacteristicCategoryDto characteristicCategoryDto) {
        return Objects.nonNull(characteristicCategoryDto) ?
                CharacteristicCategory.builder()
                        .id(characteristicCategoryDto.getId())
                        .name(characteristicCategoryDto.getName())
                        .shortDescription(characteristicCategoryDto.getShortDescription())
                        .description(characteristicCategoryDto.getDescription())
                        .parentCategory(this.dtoToEntity(characteristicCategoryDto.getParentCategory()))
                        .childCategories(Objects.nonNull(characteristicCategoryDto.getChildCategories()) ?
                                characteristicCategoryDto.getChildCategories().stream()
                                        .map(this::dtoToEntity)
                                        .collect(Collectors.toSet()):null)
                        .depth(characteristicCategoryDto.getDepth())
                        .build() : null;
    }
}
